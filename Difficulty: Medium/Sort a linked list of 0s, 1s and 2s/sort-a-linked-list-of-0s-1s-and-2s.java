/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node segregate(Node head) {
        // code here
        if (head.next == null){
            return head;
        }
        
        Node zeroHead = new Node(-1), oneHead = new Node(-1), twoHead = new Node(-1);
        Node zero = zeroHead, one = oneHead, two = twoHead;
        Node temp = head;
        
        while (temp != null){
            if (temp.data == 0){
                zero.next = temp;
                zero = zero.next;
            }else if (temp.data == 1){
                one.next = temp;
                one = one.next;
            }else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        head = zeroHead.next;
        return head;
        
    }
}
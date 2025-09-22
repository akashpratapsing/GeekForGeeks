// User function Template for Java

/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        
        Node curr = head;
        while (curr != null){
            if (curr.data == x){
                if (curr == head){
                    head = head.next;
                }
                Node prevNode = curr.prev;
                Node nextNode = curr.next;
                if (prevNode != null){
                    prevNode.next = nextNode;
                }
                if (nextNode != null){
                    nextNode.prev = prevNode;
                }
                curr = nextNode;
            }else {
                curr = curr.next;
            }
        }
        return head;
    }
}
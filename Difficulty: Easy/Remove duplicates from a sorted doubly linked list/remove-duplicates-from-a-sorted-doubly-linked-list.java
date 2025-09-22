// User function Template for Java

class Solution {
    Node removeDuplicates(Node head) {
        // Code Here.
        Node curr = head;
        while (curr != null && curr.next != null){
            Node nextNode = curr.next;
            
            while (nextNode != null && curr.data == nextNode.data){
                nextNode = nextNode.next;
            }
            curr.next = nextNode;
            if (nextNode != null){
                nextNode.prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
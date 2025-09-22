/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        // code here
        Node curr = head;
        int count = 1;
        Map<Node, Integer> map = new HashMap<>();
        while(curr != null){
            if (map.containsKey(curr)){
                return count - map.get(curr);
            }
            map.put(curr, count);
            curr = curr.next;
            count++;
        }
        return 0;
    }
}
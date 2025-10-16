/* class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Solution {
    int findCeil(Node root, int x) {
        // code here
        Node curr = root;
        int ans = -1;
        
        while (curr != null){
            
            if (curr.data == x){
                return x;
            }
            
            if (curr.data > x){
                ans = curr.data;
                curr = curr.left;
            }else {
                curr = curr.right;
            }
        }
        
        return ans;
    }
}
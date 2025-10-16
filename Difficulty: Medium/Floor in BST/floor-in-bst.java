// User function Template for Java

class Solution {
    public static int floor(Node root, int x) {
        // Code here
        Node curr = root;
        int ans = -1;
        while (curr != null){
            
            if (curr.data == x){
                return x;
            }
            
            if (curr.data < x){
                ans = curr.data;
                curr = curr.right;
            }else {
                curr = curr.left;
            }
        }
        
        return ans;
    }
}
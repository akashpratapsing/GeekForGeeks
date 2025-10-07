/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        if (!isLeaf(root)) ans.add(root.data);
        addLeftBoundry(root, ans);
        addLeaves(root, ans);
        addRightBoundry(root, ans);
        return ans;
    }
    
    void addLeftBoundry(Node root, ArrayList<Integer> ans){
        
        Node curr = root.left;
        while (curr != null){
            if (!isLeaf(curr)) ans.add(curr.data);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    
    void addLeaves(Node root, ArrayList<Integer> ans){
        
        if (isLeaf(root)){
            ans.add(root.data);
            return;
        }
        
        if (root.left != null ) addLeaves(root.left, ans);
        if (root.right != null) addLeaves(root.right, ans);
    }
    
    void addRightBoundry(Node root, ArrayList<Integer> ans){
        
        Node curr = root.right;
        Stack<Integer> st = new Stack<>();
        
        while (curr != null){
            if (!isLeaf(curr)) st.push(curr.data);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        
        while (!st.isEmpty()){
            ans.add(st.pop());
        }
    }
    
    boolean isLeaf(Node root){
        return (root.left == null) && (root.right == null);
    }
}
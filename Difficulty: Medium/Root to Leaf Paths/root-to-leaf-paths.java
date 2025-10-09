/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        getPaths(root, ans, path);

        return ans;
        
    }
    
    public static void getPaths(Node root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list){
        
        if (root == null){
            return;
        }
        
        list.add(root.data);
        if (root.left == null && root.right == null){
            ans.add(new ArrayList<>(list));
        }else {
        
            getPaths(root.left, ans, list);
            getPaths(root.right, ans, list);
            
        }
        list.remove(list.size() - 1);

    }
}
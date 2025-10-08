/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Pair{
    int line;
    Node node;
    
    Pair(Node node, int line){
        this.node = node;
        this.line = line;
    }
}
class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        
        while (!q.isEmpty()){
            
            Pair p = q.poll();
            int line = p.line;
            Node curr = p.node;
            map.put(line, curr.data);
            if (curr.left != null) q.offer(new Pair(curr.left, line - 1));
            if (curr.right != null) q.offer(new Pair(curr.right, line + 1));
        }
        
        for (Map.Entry<Integer, Integer> m : map.entrySet()){
            ans.add(m.getValue());
        }
        return ans;
    }
}
/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Pair{
    Node node;
    int line;
    
    Pair(Node node, int line){
        this.node = node;
        this.line = line;
    }
}
class Solution {
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        
        while (!q.isEmpty()){
            Pair pair = q.poll();
            int line = pair.line;
            Node curr = pair.node;
            
            if (map.get(line) == null) map.put(line, curr.data);
            if (curr.left != null) q.offer(new Pair(curr.left, line - 1));
            if (curr.right != null) q.offer(new Pair(curr.right, line + 1));
        }
        
        for (Map.Entry<Integer, Integer> m : map.entrySet()){
            ans.add(m.getValue());
        }
        return ans;
    }
}
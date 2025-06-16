class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int v = adj.size();
        boolean[] visited = new boolean[v];
        
        
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;
        
        while(!q.isEmpty()){
            
            int node = q.poll();
            ans.add(node);
            
            for (Integer i : adj.get(node)){
                if (visited[i] != true){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        
        return ans;
    }
}
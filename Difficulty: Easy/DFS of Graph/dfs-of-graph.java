class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int V = adj.size();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(adj, visited, ans, 0);
        return ans;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans, int node){
        
        visited[node] = true;
        ans.add(node);
        
        for (Integer i : adj.get(node)){
            if (!visited[i]){
                dfs(adj, visited, ans, i);
            }
        }
        
    }
}
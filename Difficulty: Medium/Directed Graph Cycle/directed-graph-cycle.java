class Solution {
    
    public boolean dfs(int node, int[] visited, int[] path, List<List<Integer>> adj){
        visited[node] = 1;
        path[node] = 1;
        
        for (int adjNode : adj.get(node)){
            if (visited[adjNode] == 0){
                if (dfs(adjNode, visited, path, adj)) return true;
            }else if (path[adjNode] == 1){
                return true;
            }
        }
        
        path[node] = 0;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        
        int[] visited = new int[V];
        int[] path = new int[V];
        
        for (int i = 0; i < V; i++){
            if (visited[i] == 0){
                if (dfs(i, visited, path, adj)) return true;
            }
        }
        return false;
    }
}
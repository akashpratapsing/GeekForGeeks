class Solution {
    
    public boolean dfs(int node, int[] visited, int[] path, int[] check, List<List<Integer>> adj){
        visited[node] = 1;
        path[node] = 1;
        check[node] = 0;
        
        for (int adjNode : adj.get(node)){
            if (visited[adjNode] == 0){
                if (dfs(adjNode, visited, path, check, adj)) return true;
            }else if (path[adjNode] == 1){
                return true;
            }
        }
        
        visited[node] = 1;
        path[node] = 0;
        check[node] = 1;
        return false;
    }
    
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        // Code here
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
        int[] check = new int[V];
        
        for (int i = 0; i < V; i++){
            if (visited[i] == 0){
                dfs(i, visited, path, check, adj);
            }
        }
        
        ArrayList<Integer> safeStates = new ArrayList<>();
        
        for (int i = 0; i < V; i++){
            if (check[i] == 1){
                safeStates.add(i);
            }
        }
        return safeStates;
    }
}
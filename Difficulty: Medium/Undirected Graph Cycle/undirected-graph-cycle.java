class Solution {
    
    public ArrayList<ArrayList<Integer>> constructAdj(int[][]edges, int V){
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges){
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
    public boolean detectCycle(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int start, int parent){
        
       visited[start] = true;
       
       for (int node : adj.get(start)){
           
           if (!visited[node]){
               if (detectCycle(adj, visited, node, start)) return true;
           }else if (node != parent){
               return true;
           }
       }
       return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = constructAdj(edges, V);
        boolean[] visited = new boolean[V];
        
        for (int i = 0; i < V; i++){
            if (!visited[i]){
                if (detectCycle(adj, visited, i, -1)){
                    return true;
                }
            }
        }
        return false;
    }
}
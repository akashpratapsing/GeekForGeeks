class Solution {
    
    public boolean bipartite(int node, int c, List<List<Integer>> adj, int[] color){
        
        color[node] = c;
        
        for (int it : adj.get(node)){
            if (color[it] == -1){
                if (!bipartite(it, 1 - color[node], adj, color)) return false;
            }else if (color[it] == c){
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges){
            int u =  edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!bipartite(i, 0, adj, color)) return false;
            }
        }
        
        return true;
    }
}
// User function Template for Java
class Solution {
    
    public void topoSort(int node, Stack<Integer> st, int[] vis, List<List<int[]>> adj){
        
        vis[node] = 1;
        for (int[] it: adj.get(node)){
            int v = it[0];
            if(vis[v] == 0){
                topoSort(v, st, vis, adj);
            }
        }
        st.push(node);
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        List<List<int[]>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new int[] {v, wt});
        }
        
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++){
            if (vis[i] == 0){
                topoSort(i, st, vis, adj);
            }
        }
        
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[0] = 0;
        
        while (!st.isEmpty()){
            int node = st.pop();
            
            for (int[] it: adj.get(node)){
                int v = it[0];
                int wt = it[1];
                
                if (dist[node] + wt < dist[v]){
                    dist[v] = dist[node] + wt;
                }
            }
        }
        
        for (int i = 0; i < V; i++){
            if (dist[i] == (int) 1e9){
                dist[i] = -1;
            }
        }
        
        return dist;
    }
}
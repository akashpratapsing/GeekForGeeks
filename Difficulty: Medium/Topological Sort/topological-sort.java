class Solution {
    
    public void dfs(int node, int[] vis, Stack<Integer> st, List<List<Integer>> adj){
        vis[node] = 1;
        for (int adjNode : adj.get(node)){
            if (vis[adjNode] == 0){
                dfs(adjNode, vis, st, adj);
            }
        }
        st.push(node);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
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
        
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++){
            if(vis[i] == 0){
                dfs(i, vis, st, adj);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while (!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
}
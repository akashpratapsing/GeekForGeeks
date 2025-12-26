class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];
        dfs(adj, visited, ans, 0);
        return ans;
    }
    
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans, int node){
        
        visited[node] = true;
        ans.add(node);
        
        for (int i : adj.get(node)){
            if (!visited[i]){
                dfs(adj, visited, ans, i);
            }
        }
        
    }
}
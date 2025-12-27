// User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        for (int i = 0; i < V; i++){
            mat.add(new ArrayList<>());
        }
        
        for (int i = 0; i < V; i++){
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1 && i != j){
                    mat.get(i).add(j);
                    mat.get(j).add(i);
                }
            }
        }
        
        boolean[] visited = new boolean[V];
        int count = 0;
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]){
                count++;
                dfs(mat, visited, i);
            }
        }
        
        return count;
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node){
        
        visited[node] = true;
        
        for (int i : adj.get(node)){
            if (!visited[i]){
                dfs(adj, visited, i);
            }
        }
    }
}
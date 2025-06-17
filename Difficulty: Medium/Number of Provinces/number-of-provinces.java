// User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for (int i = 0; i < V; i++){
            adjList.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < V; i++){
            for (int j = 0; j < V; j++){
                if (adj.get(i).get(j) == 1 && i != j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++){
            if (!visited[i]){
                count++;
                dfs(adjList, i, visited);
            }
        }
        return count;
    }
    
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited){
        
        visited[node] = true;
        
        for (Integer i : adj.get(node)){
            if (!visited[i]){
                dfs(adj, i, visited);
            }
        }
    }
};
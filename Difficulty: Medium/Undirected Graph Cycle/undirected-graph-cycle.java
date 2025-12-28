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
    public boolean detectCycle(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int start){
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {start, -1});
        visited[start] = true;
        
        while (!q.isEmpty()){
            
            int node = q.peek()[0];
            int parent = q.peek()[1];
            q.poll();
            
            for (int neighbor : adj.get(node)){
                
                if (!visited[neighbor]){
                    visited[neighbor] = true;
                    q.offer(new int[] {neighbor, node});
                } else if (neighbor != parent){
                    return true;
                }
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
                if (detectCycle(adj, visited, i)){
                    return true;
                }
            }
        }
        return false;
    }
}
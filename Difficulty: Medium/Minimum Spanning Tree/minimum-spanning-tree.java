class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge: edges){
            adj.get(edge[0]).add(new int[] {edge[1], edge[2]});
            adj.get(edge[1]).add(new int[] {edge[0], edge[2]});
        }
        
        int[] vis = new int[V];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.offer(new int[] {0, 0});
        int sum = 0;
        while (!q.isEmpty()){
            
            int node = q.peek()[0];
            int wt = q.peek()[1];
            q.poll();
            
            if (vis[node] == 1) continue;
            vis[node] = 1;
            sum += wt;
            
            for (int[] it : adj.get(node)){
                int adjNode = it[0];
                int edW = it[1];
                if (vis[adjNode] != 1){
                    q.offer(new int[] {adjNode, edW});
                }
            }
        }
        return sum;
    }
}

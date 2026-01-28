class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges){
            adj.get(edge[0]).add(new int[] {edge[1], edge[2]});
            adj.get(edge[1]).add(new int[] {edge[0], edge[2]});
        }
        
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        
        for (int i = 1; i <= n; i++){
            dist[i] = (int) 1e9;
            parent[i] = i;
        }
        
        dist[1] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[] {0, 1});
        
        while (!q.isEmpty()){
            
            int node  = q.peek()[1];
            int dis = q.peek()[0];
            q.poll();
            
            for (int[] it : adj.get(node)){
                int adjNode = it[0];
                int wt = it[1];
                
                if (dis + wt < dist[adjNode]){
                    dist[adjNode] = dis + wt;
                    q.offer(new int[] {dist[adjNode], adjNode});
                    parent[adjNode] = node;
                }
            }
        }
        
        List<Integer> path = new ArrayList<>();
        if (dist[n] == (int) 1e9){
            path.add(-1);
            return path;
        }
        
        int node = n;
        while (parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        
        path.add(1);
        Collections.reverse(path);
        path.add(0, dist[n]);
        return path;
    }
}
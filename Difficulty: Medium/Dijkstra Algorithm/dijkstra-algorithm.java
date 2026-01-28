class Pair {
    int first;
    int second;
    
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge: edges){
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }
        
        PriorityQueue<Pair> q = new PriorityQueue<>((x, y) -> x.first - y.first);
        
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;
        q.offer(new Pair(0, src));
        
        while (!q.isEmpty()){
            int dis = q.peek().first;
            int node = q.peek().second;
            q.poll();
            
            for (Pair it: adj.get(node)){
                int adjNode = it.first;
                int wt = it.second;
                
                if (dis + wt < dist[adjNode]){
                    dist[adjNode] = dis + wt;
                    q.offer(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
}
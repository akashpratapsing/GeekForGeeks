class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        visited[0] = true;
        q.offer(0);
        
        while (!q.isEmpty()) {
            
            int node = q.poll();
            ans.add(node);
            
            for (int i : adj.get(node)){
                if (!visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return ans;
    }
}
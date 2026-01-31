// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        if (start == end) return 0;
        
        int mod = 100000;
        
        int[] dist = new int[100000];
        Arrays.fill(dist, (int) 1e9);
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, start});
        dist[start] = 0;
        
        while (!q.isEmpty()){
            
            int steps = q.peek()[0];
            int node = q.peek()[1];
            q.poll();
            
            for (int it: arr){
                
                int val = (node * it) % mod;
                
                if (steps + 1 < dist[val]){
                    
                dist[val] = steps + 1;
                if (val == end) return steps + 1;
                q.offer(new int[] {steps + 1, val});
                
                }
            }
        }
        
        return -1;
    }
}

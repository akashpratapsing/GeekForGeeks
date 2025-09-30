// User function Template for Java

class Solution {
    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        int n = bt.length;
        int t = 0, wt = 0;
        
        for (int i = 0; i < n; i++){
            
            wt += t;
            t += bt[i];
        }
        return wt / n;
    }
}

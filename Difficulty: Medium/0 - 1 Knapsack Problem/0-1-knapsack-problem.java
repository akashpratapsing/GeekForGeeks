class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int[][] dp = new int[n][W + 1];
        for (int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return f(W, val, wt, n - 1, dp);
    }
    
    public int f(int w, int[] val, int[] wt, int ind, int[][] dp){
        
        if (ind == 0) {
            if (wt[0] <= w) return val[0];
            return 0;
        } 
        
        if (dp[ind][w] != -1) return dp[ind][w];
        
       
        int notTake = f(w, val, wt, ind - 1, dp);
        int take = Integer.MIN_VALUE;
        if (wt[ind] <= w){
            take = val[ind] + f(w - wt[ind], val, wt, ind - 1, dp);
        }
        return dp[ind][w] = Math.max(take, notTake);
    }
}
    
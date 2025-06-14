// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][]) {
        
        
        // code here
        
        int[][] dp = new int[arr.length][4];
        
        for (int[] array : dp){
            Arrays.fill(array, -1);
        }
        
        return solve(arr, arr.length - 1, 3, dp);
        
    }
    
    public int solve(int[][] arr, int day, int last, int[][] dp){
        
        if (day == 0){
            int max = 0;
            for (int i = 0; i < 3; i++){
                
                if (i != last){
                    max = Math.max(max, arr[day][i]); 
                }
            }
            
            return max;
         }
         
         if (dp[day][last] != -1){
             return dp[day][last];
         }
         
         int max = 0;
            for (int i = 0; i < 3; i++){
                
                if (i != last){
                    
                   int train = arr[day][i] + solve(arr, day - 1, i, dp); 
                    max = Math.max(max, train); 
                }
            }
         return dp[day][last] = max;
    }
}
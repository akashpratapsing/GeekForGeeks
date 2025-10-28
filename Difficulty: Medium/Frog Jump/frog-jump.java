// User function Template for Java
class Solution {
    int minCost(int[] height) {
        // code here
        int n = height.length;
        int prev1 = 0;
        int prev2 = 0;
        
        for (int i = 1; i < n; i++){
            
            int j2 = Integer.MAX_VALUE;
            
            int j1 = prev1 + Math.abs(height[i] - height[i - 1]);
            
            if (i > 1){
                j2 = prev2 + Math.abs(height[i] - height[i - 2]);
            }
            int cost = Math.min(j1, j2);
            prev2 = prev1;
            prev1 = cost;
        }
        return prev1;
    }
}
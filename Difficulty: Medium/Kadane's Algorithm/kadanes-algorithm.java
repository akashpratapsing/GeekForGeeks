class Solution {
    int maxSubarraySum(int[] arr) {
        // Code here
        int sum = arr[0];
        int maxSum = sum;
        
        for (int i = 1; i < arr.length; i++){
            
            sum = Math.max(sum + arr[i], arr[i]);
            maxSum = Math.max(sum, maxSum);
 
        }
        
        
        return maxSum;
    }
}

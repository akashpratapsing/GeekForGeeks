// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        int maxLen = 0;
        int sum = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            if (sum == k){
                maxLen = Math.max(maxLen, i + 1);
            }
            
            int rem = sum - k;
            
            if (preSum.containsKey(rem)){
                maxLen = Math.max(maxLen, i - preSum.get(rem));
            }
            
            if (!preSum.containsKey(sum)){
                preSum.put(sum, i);
            }
            
        }
        
        return maxLen;
    }
}

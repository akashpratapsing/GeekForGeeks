class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        boolean[] prev = new boolean[sum + 1];
        
        prev[0] = true;
        if (arr[0] <= sum){
        prev[arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++){
            boolean[] curr = new boolean[sum + 1];
            curr[0] = true;
            for (int target = 1; target <= sum; target++){
               boolean notTake = prev[target];
               boolean take = false;
               if (target >= arr[ind]){
                  take = prev[ target - arr[ind]];
                } 
                curr[target] = take || notTake;
            }
            prev = curr;
            
        }
        return prev[sum];
    }
}
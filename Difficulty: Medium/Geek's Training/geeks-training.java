// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][]) {
        // code here
        int[] dp = new int[4];
        int n = arr.length;
        
        dp[0] = Math.max(arr[0][1], arr[0][2]);
        dp[1] = Math.max(arr[0][0], arr[0][2]);
        dp[2] = Math.max(arr[0][0], arr[0][1]);
        dp[3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));

        for (int day = 1; day < n; day++){
            int[] temp = new int[4];

            for (int last = 0; last < 4; last++){         
                for (int task = 0; task < 3; task++){

                    if (task != last){
                        temp[last] = Math.max(temp[last], arr[day][task] + dp[task]);
                    }
                }
            }
            dp = temp;
        }
        return dp[3];
    }
}
class Solution {
    int countWays(int n) {
        // your code here
        
        if (n == 1 || n == 2){
            return n;
        }
        int temp1 = 1;
        int temp2 = 2;
        
        for (int i = 3; i <= n; i++){
            int temp = temp1 + temp2;
            temp1 = temp2;
            temp2 = temp;
        }
        return temp2;
    }
}

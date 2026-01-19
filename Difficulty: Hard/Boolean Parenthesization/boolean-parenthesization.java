// User function Template for Java
class Solution {
    
    public static int f(int i, int j, int isTrue, String s, int[][][] dp){
        if (i > j) return 0;
        
        if (i == j){
            if (isTrue == 1) return s.charAt(i) == 'T' ? 1 : 0;
            else return s.charAt(i) == 'F' ? 1 : 0;
        }
        
        if (dp[i][j][isTrue] != -1) return dp[i][j][isTrue];
        
        int ways = 0;
        for (int ind = i + 1; ind <= j - 1; ind+=2){
            int lT = f(i, ind - 1, 1, s, dp);
            int lF = f(i, ind - 1, 0, s, dp);
            int rT = f(ind + 1, j, 1, s, dp);
            int rF = f(ind + 1, j, 0, s, dp);
            
            if (s.charAt(ind) == '&'){
                
                if (isTrue == 1){
                    ways += (lT * rT);
                }else {
                    ways += ((lT * rF) + (lF * rT) + (lF * rF));
                }
            }else if (s.charAt(ind) == '|'){

                if (isTrue == 1){
                    ways += ((lT * rT) + (lT * rF) + (lF * rT));
                }else {
                    ways += (lF * rF);
                }                
            }else {

                if (isTrue == 1){
                    ways += ((lT * rF) + (lF * rT));
                }else {
                    ways += ((lT * rT) + (lF * rF));
                }                      
            }
        }
        return dp[i][j][isTrue] = ways;
    }
    static int countWays(String s) {
        // code here
        int n = s.length();
        int[][][] dp = new int[n][n][2];
        for (int[][] a : dp){
            for (int[] b : a){
                Arrays.fill(b, -1);
            }
        }
        return f(0, n - 1, 1, s, dp);
    }
}
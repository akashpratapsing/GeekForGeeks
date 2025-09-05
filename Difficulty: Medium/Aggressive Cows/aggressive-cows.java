class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int n = stalls[stalls.length - 1] - stalls[0];
        
        for (int i = 1; i <= n; i++){
            if (canPlace(stalls, k, i)){
                continue;
            }else {
                return i - 1;
            }
        }
        
        return n;
        
    }
    
    public boolean canPlace(int[] stalls, int k, int dis){
        int cows = 1;
        int last = stalls[0];
        
        for (int i = 1; i < stalls.length; i++){
            if (stalls[i] - last >= dis){
                cows += 1;
                last = stalls[i];
            }
            if (cows >= k) return true;
        }
        return false;
    }
}
class Solution {
    public static ArrayList<Integer> primeFac(int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int i = 2; i <= n; i++){
            if (n % i == 0){
                if (isPrime(i)){
                    ans.add(i);
                }
            }
        }
        return ans;
        
    }
    
    public static boolean isPrime(int n){
        
        for (int i = 2; i * i <= n; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
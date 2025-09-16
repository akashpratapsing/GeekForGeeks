// User function Template for Java

class Solution {
    public static int findXOR(int l, int r) {
        return findXOR1ToN(l - 1) ^ findXOR1ToN(r);
    }
    
    public static int findXOR1ToN(int n){
        
        if (n % 4 == 1){
            return 1;
        }else if (n % 4 == 2){
            return n + 1;
        }else if (n % 4 == 3){
            return 0;
        }else {
            return n;
        }
        
    }
}
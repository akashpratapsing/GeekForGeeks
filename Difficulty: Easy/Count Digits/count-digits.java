// User function Template for Java

class Solution {
    static int evenlyDivides(int n) {
        // code here
        int count = 0;
        int num = n;
        while (num > 0){
            int d = num % 10;
            if (d != 0 && n % d == 0) count++;
            num /= 10;
        }
        return count;
    }
}
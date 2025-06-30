class Solution {
    int findFrequency(int arr[], int x) {
        // code here
        int count = 0;
        
        for (int i : arr){
            if (i == x){
                count++;
            }
        }
        
        return count;
    }
}
class Solution {
    public int median(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int start = 2001;
        int end = 0;
        int req = (m * n) / 2;
        
        for (int i = 0; i < n; i++){
            start = Math.min(start, mat[i][0]);
            end = Math.max(end, mat[i][m - 1]);
        }
        
        while (start <= end){
            
            int mid = start + (end - start) / 2;
            int lessEqual = findValue(mat, mid, n, m);
            
            if (lessEqual <= req){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return start;
    }
    
    public int findValue(int[][] mat, int val, int n, int m){
        
        int count = 0;
        for (int i = 0; i < n; i++){
            count += upperBound(mat[i], val,  m);
        }
        return count;
    }
    
    public int upperBound(int[] arr, int val, int m){
        
        int start = 0;
        int end = m - 1;
        
        while (start <= end){
            
            int mid = start + (end - start) / 2;
            
            if (arr[mid] <= val){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return start;
    }
}
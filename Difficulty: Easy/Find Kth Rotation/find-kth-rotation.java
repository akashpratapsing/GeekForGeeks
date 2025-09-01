class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        
        
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        
        while (start <= end){
            
            int mid = start + (end - start) / 2;
            ans = mid;
            
            if (arr[start] <= arr[mid] && arr[end] <= arr[mid]){
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        
        return ans;
            
    }
}
class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        
        
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        int min = Integer.MAX_VALUE;
        
        while (start <= end){
            
            int mid = start + (end - start) / 2;
            
            if (arr[start] <= arr[end]){
                if (min > arr[start]){
                    ans = start;
                    min = arr[start];
                }
                break;
            }
            
            if (arr[start] <= arr[mid]){
                if (min > arr[start]){
                    ans = start;
                    min = arr[start];
                }
                start = mid + 1;
            }else {
                if (min > arr[mid]){
                    ans = mid;
                    min = arr[mid];
                }
                end = mid - 1;
            }
        }
        
        return ans;
            
    }
}
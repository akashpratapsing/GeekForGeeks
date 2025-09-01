class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        
        int first = find(arr, target, true);
        if (first == -1){
            return 0;
        }
        
        int last = find(arr, target, false);
        
        return last - first + 1;
        
    }
    
    int find(int[] arr, int target, boolean isFirst){
        
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        
        while (start <= end){
            
            int mid = start + (end - start) / 2;
            
            if (arr[mid] > target){
                end = mid - 1;
            }else if (arr[mid] < target){
                start = mid + 1;
            }else {
                ans = mid;
                
                if (isFirst){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
        }
        
        return ans;
    }
}

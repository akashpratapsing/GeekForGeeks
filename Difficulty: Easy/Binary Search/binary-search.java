class Solution {
    public int binarysearch(int[] arr, int k) {
        // Code Here
        int start = 0;
        int end = arr.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (arr[mid] >= k){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return  start >= 0 && start < arr.length && arr[start] == k ? start : -1;
    }
}
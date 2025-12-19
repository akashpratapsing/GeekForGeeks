class Solution {
    public int findPages(int[] arr, int k) {
        // code here
        if (k > arr.length) return -1;
        int start = 0, end = 0;
        for (int i : arr){
            start = Math.max(start, i);
            end += i;
        }
        
        while (start <= end){
            
            int mid = start + (end - start) / 2;
            
            if (maxPages(arr, mid) <= k){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }
    
    public int maxPages(int[] arr, int pages){
        
        int stu = 1;
        int pagePerStudent = 0;
        
        for (int i = 0; i < arr.length; i++){
            if (pagePerStudent + arr[i] <= pages){
                pagePerStudent += arr[i];
            }else {
                stu++;
                pagePerStudent = arr[i];
            }
        }
        
        return stu;
        
    }
}
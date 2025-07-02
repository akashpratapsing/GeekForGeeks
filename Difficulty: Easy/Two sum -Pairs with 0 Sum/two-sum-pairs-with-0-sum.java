// User function Template for Java

class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        // code here
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        
        int left = 0, right = arr.length - 1;
        
        while (left < right){
            
            int sum = arr[left] + arr[right];
            
            if (sum == 0){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[left]);
                list.add(arr[right]);
                result.add(list);
                
                int rVal = arr[right], lVal = arr[left];
                while (left < right && arr[left] == lVal){
                    left++;
                }
                while (left < right && arr[right] == rVal){
                    right--;
                }                
            }else if (sum > 0){
                right--;
            }else {
                left++;
            }
        }
        
        return result;
    }
    
}

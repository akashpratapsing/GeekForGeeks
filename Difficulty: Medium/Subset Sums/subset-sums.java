// User function Template for Java//User function Template for Java
class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        helper(arr, 0, 0, result);
        return result;
    }
    
    public void helper(int[] arr, int sum, int index, ArrayList<Integer> result){
        if (index == arr.length){
            result.add(sum);
            return;
        }
        helper(arr, sum + arr[index], index + 1, result);
        helper(arr, sum, index + 1, result);
    }
}
class Solution {
    public List<Integer> frequencyCount(int[] arr) {
        // code here
        int[] freq = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            freq[arr[i] - 1]++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i : freq){
            ans.add(i);
        }
        return ans;
    }
}

class Solution {
    public static int firstRepeated(int[] arr) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (int i = 0; i < arr.length; i++){
            if (map.get(arr[i]) > 1){
                return i + 1;
            }
        }
        
        return -1;
    }
}

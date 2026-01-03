class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++){
            heap.offer(arr[i]);
            if (heap.size() > k){
                heap.poll();
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!heap.isEmpty()){
            ans.add(0, heap.poll());
        }
        return ans;
    }
}

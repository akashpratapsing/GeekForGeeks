class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++){
            heap.offer(arr[i]);
            if (heap.size() > k){
                heap.poll();
            }
        }
        return heap.peek();
    }
}

class Solution {
    public void nearlySorted(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int ind = 0;
        for (int i = 0; i < arr.length; i++){
            heap.offer(arr[i]);
            if (heap.size() > k){
                arr[ind++] = heap.poll();
            }
        }
        
        while (!heap.isEmpty()) arr[ind++] = heap.poll();
    }
}

class myQueue {
    
    int[] arr;
    int start;
    int end;
    int currsize;
    int maxsize;

    // Constructor
    public myQueue(int n) {
        // Define Data Structures
        this.arr = new int[n];
        this.start = -1;
        this.end = -1;
        this.maxsize = n;
        this.currsize = 0;
    }

    public boolean isEmpty() {
        // Check if queue is empty
        return start == -1;
    }

    public boolean isFull() {
        // Check if queue is full
        return currsize == maxsize;
    }

    public void enqueue(int x) {
        // Enqueue
        if (isFull()){
            return;
        }
        if (isEmpty()){
            start = 0;
            end = 0;
        }else {
            end = (end + 1) % maxsize;
        }
            arr[end] = x;
            currsize++;
    }

    public void dequeue() {
        // Dequeue
        if (isEmpty()){
            return;
        }
        
        if (currsize == 1){
            start = -1;
            end = -1;
        }else {
            start = (start + 1) % arr.length;
        }
        currsize--;
    }

    public int getFront() {
        // Get front element
        if (isEmpty()){
            return -1;
        }
        return arr[start];
    }

    public int getRear() {
        // Get last element
        if (isEmpty()){
            return -1;
        }
        return arr[end];
    }
}

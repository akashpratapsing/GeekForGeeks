class Pair {
    
    double first;
    int second;
    
    public Pair(double first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public double minMaxDist(int[] stations, int K) {
        // code here
        int n = stations.length;
        if (n == 1) return 0d;
        int[] howmany = new int[n - 1];
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));
        
        for (int i = 0; i < n - 1; i++){
            q.add(new Pair(stations[i + 1] - stations[i], i));
        }

        for (int i = 1; i <= K; i++){
            Pair p = q.poll();
            int index = p.second;
            howmany[index]++;
            double newLength = (double) (stations[index + 1] - stations[index]) / (double) (howmany[index] + 1);
            q.add(new Pair(newLength, index));
        }
        
        return q.peek().first;
    }
}

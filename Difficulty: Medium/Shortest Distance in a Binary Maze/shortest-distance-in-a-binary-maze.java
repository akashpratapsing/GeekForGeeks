// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        if (source[0] == destination[0] && source[1] == destination[1]){
            return 0;
        }
        
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] dist = new int[n][m];
        for (int[] a: dist){
            Arrays.fill(a, (int) 1e9);
        }
        dist[source[0]][source[1]] = 0;
        
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, source[0], source[1]});
        
        while (!q.isEmpty()){
            int row = q.peek()[1];
            int col = q.peek()[2];
            int dis = q.peek()[0];
            q.poll();
            
            for (int i = 0; i < 4; i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                    grid[nRow][nCol] == 1 && dis + 1 < dist[nRow][nCol]){
                        
                        if (destination[0] == nRow && destination[1] == nCol){
                            return dis + 1;
                        }
                        
                        dist[nRow][nCol] = dis + 1;
                        q.offer(new int[] {dis + 1, nRow, nCol});
                    }
            }
        }
        return -1;
    }
}

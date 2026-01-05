class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        
        int n = grid.length;
        int m = grid[0].length;
        ArrayList<ArrayList<Integer>> dist = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++){
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 1){
                    visited[i][j] = true;
                    q.offer(new int[] {i, j, 0});
                }
               list.add(0); 
            }
            dist.add(list);
        }
        
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        while (!q.isEmpty()){
            
            int row = q.peek()[0];
            int col = q.peek()[1];
            int d = q.peek()[2];
            q.poll();
            dist.get(row).set(col, d);
            for (int i = 0; i < 4; i++){
                
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                    !visited[nRow][nCol] && grid[nRow][nCol] == 0){
                        visited[nRow][nCol] = true;
                        q.offer(new int[] {nRow, nCol, d + 1});
                    }
            }
        }
        return dist;
    }
}
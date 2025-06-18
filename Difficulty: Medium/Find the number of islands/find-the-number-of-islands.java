class Pair{
    
    int first;
    int sec;
    
    public Pair(int first, int sec){
        this.first = first;
        this.sec = sec;
    }
}

class Solution {
    
    public void bfs(char[][] grid, boolean[][] visited, int r, int c){
        
        visited[r][c] = true;
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(r, c));

        
        while(!q.isEmpty()){
            
            int row = q.peek().first;
            int col = q.peek().sec;
            q.remove();
            
             for (int dRow = -1; dRow <= 1; dRow++){
                 for (int dCol = -1; dCol <= 1; dCol++){
                     
                     int nRow = row + dRow;
                     int nCol = col + dCol;
                     
                     if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && 
                     grid[nRow][nCol] == 'L' && !visited[nRow][nCol] ){
                         visited[nRow][nCol] = true;
                         q.add(new Pair(nRow, nCol));
                     }
                 }
             }
            
        }
        
       
    }
    
    public int countIslands(char[][] grid) {
        // Code here
        
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        
        int count = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (!visited[i][j] && grid[i][j] == 'L'){
                    bfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
}
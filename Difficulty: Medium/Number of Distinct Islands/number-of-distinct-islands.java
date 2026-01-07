// User function Template for Java

class Solution {
    
    void dfs(int row, int col, int row0, int col0, int[][] grid, boolean[][] visited, List<String> list){
        
        visited[row][col] = true;
        list.add((row - row0) + "," + (col - col0));
        
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        
        for (int i = 0; i < 4; i++){
            
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];
            
            if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length &&
                !visited[nRow][nCol] && grid[nRow][nCol] == 1){
                    dfs(nRow, nCol, row0, col0, grid, visited, list);
                }
        }
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        
        Set<List<String>> set = new HashSet<>();
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                
                if (!visited[i][j] && grid[i][j] == 1){
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i, j, i, j, grid, visited, list);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
}

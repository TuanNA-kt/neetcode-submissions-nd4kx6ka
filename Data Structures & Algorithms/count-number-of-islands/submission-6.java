class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        int ROW = grid.length;
        int COL = grid[0].length;    
        for(int i = 0; i < ROW; i++) {
            for(int j = 0; j < COL; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        if(r >= ROWS || c >= COLS || r < 0 || c < 0 || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    private void bfs(char[][] grid, int row, int column) {
        Queue<int[]> queue = new LinkedList<>();
        int ROWS = grid.length;
        int COLS = grid[0].length;

        int[][] directions = new int[][] {
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };
        
        queue.offer(new int[] {row, column});
        grid[row][column] = '0';

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            for(int[] d : directions) {
                int newR = r + d[0];
                int newC = c + d[1];
                int[] coordinate = new int[] {newR, newC};
                if(newR >= 0 && newC >= 0 && newR < ROWS && newC < COLS 
                && grid[newR][newC] == '1') {
                    queue.offer(coordinate);
                    grid[newR][newC] = '0';
                }
            }
        }
    }
}

class Solution {
    int area = 0;
    public int maxAreaOfIsland(int[][] grid) {
        area = 0;
        int max = 0;
        int ROWS = grid.length;
        int COLS = grid[0].length;
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(grid[i][j] == 1) {
                    area = 0;
                    dfs(grid, i, j, ROWS, COLS);
                    if(max < area) max = area;
                }
            }
        }

        return max;
    }

    private void dfs(int[][] grid, int r, int c, int ROWS, int COLS) {
        if(r >= ROWS || c >= COLS || r < 0 || c < 0 || grid[r][c] == 0) {
            return;
        }

        grid[r][c] = 0;
        area++;
        dfs(grid, r + 1, c, ROWS, COLS);
        dfs(grid, r - 1, c, ROWS, COLS);
        dfs(grid, r, c + 1, ROWS, COLS);
        dfs(grid, r, c - 1, ROWS, COLS);
    }
}

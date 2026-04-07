class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int ROW = grid.length;
        int COL = grid[0].length;    
        for(int i = 0; i < ROW; i++) {
            for(int j = 0; j < COL; j++) {
                if(grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
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
            for(int[] d : directions) {
                int r = current[0];
                int c = current[1];
                r += d[0];
                c += d[1];
                if(r >= 0 && c >= 0 && r < ROWS && c < COLS 
                && grid[r][c] == '1' && !queue.contains(d)) {
                    queue.offer(new int[] {r, c});
                    grid[r][c] = '0';
                }
            }
        }
    }

}

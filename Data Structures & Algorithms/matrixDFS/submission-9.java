class Solution {
    int res = 0;
    public int countPaths(int[][] grid) {
        res = 0;
        Set<String> set = new HashSet<>();
        dfs(grid, 0, 0, set);
        return res;
    }

    private int dfs(int[][] grid, int row, int column, Set<String> set) {
        int ROW = grid.length;
        int COL = grid[0].length;
        if(row < 0 || column < 0 || set.contains(row + ", " + column)
         || row == ROW || column == COL || grid[row][column] == 1 ) {
            return 0;
        }

        if(row == ROW - 1 && column == COL - 1) {
            res++;
            return 1;
        }

        set.add(row + ", " + column);

        int count = 0;
        count += dfs(grid, row + 1, column, set);
        count += dfs(grid, row, column + 1, set);
        count += dfs(grid, row - 1, column, set);
        count += dfs(grid, row, column - 1, set);

        set.remove(row + ", " + column);

        return count;
        
    }
}

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int m = obstacleGrid.length;
        int[] prev = new int[n];
        prev[n - 1] = 1;
        for(int i = m - 1; i >= 0; i--) {
            int[] cur = new int[n];
            if(obstacleGrid[i][n - 1] == 1)  cur[n - 1] = 0;
            else cur[n - 1] = prev[n - 1];
            
            for(int j = n - 2; j >= 0; j--) {
                if(obstacleGrid[i][j] == 1) continue;
                cur[j] = cur[j + 1] + prev[j];
            }

            prev = cur;
        }

        return prev[0];
    }
}
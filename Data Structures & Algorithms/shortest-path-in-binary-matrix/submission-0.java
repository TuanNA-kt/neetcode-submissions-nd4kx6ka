class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int length = 1;
        int[][] visited = new int[ROWS][COLS];
        int[][] directions = {{-1, 0}, {-1, 1}, {-1, -1}, {1, 0}, 
        {1, 1}, {1, -1}, {0, 1}, {0, -1}};

        Queue<int[]> queue = new LinkedList();

        if(grid[0][0] != 0 || grid[ROWS - 1][COLS - 1] != 0) return -1;

        queue.offer(new int[] {0, 0});
        visited[0][0] = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                if(temp[0] == ROWS - 1 && temp[1] == COLS - 1) return length;
                for(int[] d : directions) {
                    int r = temp[0] + d[0];
                    int c = temp[1] + d[1];
                    if(r >=0 && c >= 0 && r < ROWS && c < COLS
                    && grid[r][c] == 0 && visited[r][c] != 1) {
                        queue.add(new int[] {r, c});
                        visited[r][c] = 1;
                    }
                }
            }
            length++;
        }

        return -1;
    }
}
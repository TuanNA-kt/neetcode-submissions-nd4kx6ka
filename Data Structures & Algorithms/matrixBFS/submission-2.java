class Solution {
    public int shortestPath(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int length = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[ROWS][COLS];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                if(temp[0] == ROWS - 1 && temp[1] == COLS - 1) return length;
                for(int[] d : directions) {
                    int r = temp[0] + d[0];
                    int c = temp[1] + d[1];
                    int[] newCoor = {r, c};
                    if(r >= 0 && c >= 0 && r < ROWS && c < COLS && grid[r][c] == 0 && !visited[r][c]) {
                        queue.offer(newCoor);
                        visited[r][c] = true;
                    }
                }
            }
            length++;
        }

        return -1;
    }
}

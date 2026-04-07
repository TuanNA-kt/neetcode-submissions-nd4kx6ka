class Solution {
    public int orangesRotting(int[][] grid) {
                int ROWS = grid.length;
        int COLS = grid[0].length;
        int length = 1;
        int[][] rottenFruit = new int[ROWS][COLS];
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Set<String> freshCoor = new HashSet<>();
        //Set<String> rottenCoor = new HashSet<>();
        Queue<int[]> rottenCoor = new LinkedList();

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(grid[i][j] == 1) freshCoor.add(i + "," + j);
                if(grid[i][j] == 2) {
                    rottenCoor.offer(new int[] {i, j});
                    rottenFruit[i][j] = 1;
                }
            }
        }

        if(freshCoor.isEmpty()) return 0;
        if(rottenCoor.isEmpty()) return -1;

        while(!rottenCoor.isEmpty()) {
            int size = rottenCoor.size();
            for(int i = 0; i < size; i++) {
                int[] temp = rottenCoor.poll();

                for(int[] d : directions) {
                    int r = temp[0] + d[0];
                    int c = temp[1] + d[1];
                    if(r >= 0 && c >= 0 && r < ROWS && c < COLS
                    && grid[r][c] == 1 && rottenFruit[r][c] != 1) {
                        rottenCoor.offer(new int[] {r, c});
                        rottenFruit[r][c] = 1;
                        freshCoor.remove(r + "," + c);
                        if(freshCoor.isEmpty()) return length;
                    }
                }
            }
            length++;
        }
        
        return -1;
    }
}

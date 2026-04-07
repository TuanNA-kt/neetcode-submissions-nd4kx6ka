class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;    

        int L = 0;
        int R = row * column - 1;
        
        while(L <= R) {
            int M = (L + R) / 2;
            int c = M % column;
            int r = (M - c) / column;

            if(target == matrix[r][c]) {
                return true;
            } else if(target < matrix[r][c]) {
                R = M - 1;
            } else {
                L = M + 1;
            }
        }

        return false;
    }

}

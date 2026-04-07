class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        
        for(int i = m; i > 0; i--) {
            int[] cur = new int[n];
            cur[n - 1] = 1;
            
            for(int j = n - 2; j >= 0; j--) {
                cur[j] = cur[j + 1] + prev[j];
            }

            prev = cur;
        }

        return prev[0];
    }
}

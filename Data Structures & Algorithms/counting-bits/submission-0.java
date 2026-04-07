class Solution {
    public int[] countBits(int n) {
        int[] count = new int[n + 1];
        int cnt = 0;
        for(int i = 0; i <= n; i++) {
            count[i] = cnt + hammingWeight(i);
        }
        return count;
    }

    private int hammingWeight(int n) {
        int adder = 1;
        int count = 0;
        for(int i = 0; i < 64; i++) {
            if((n & adder) != 0) count++;
            adder *= 2;
        }
        return count;
    }
}

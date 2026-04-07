class Solution {
    public int hammingWeight(int n) {
        int adder = 1;
        int count = 0;
        for(int i = 0; i < 32; i++) {
            if((n & adder) != 0) count++;
            adder *= 2;
        }
        return count;
    }
}

class Solution {
    public int reverseBits(int n) {
        int[] arr = new int[32];
        int temp = n;
        int index = 0;
        int res = 0;
        
        for(int i = 0; i < 32; i++) {
            if(temp != (temp >>> 1 << 1)) {
                res |= 1 << (31 - i);
            }
            temp = temp >>> 1;
        }

        return res;
    }
}

class Solution {
    public int[] countBits(int n) {
        if(n == 0) return new int[] {0};

        int[] arr = new int[n + 1];

        arr[0] = 0;
        arr[1] = 1;

        int m = 1;
        int index = 2;
        while(index < n + 1) {
            int lower = (1 << m);
            int upper = (1 << (m + 1));

            for(int i = lower; i < upper; i++) {
                if(index > n) break;
                arr[index] = arr[i - lower] + 1;
                index++;
            }

            m++;
        }

        return arr;
    }

}

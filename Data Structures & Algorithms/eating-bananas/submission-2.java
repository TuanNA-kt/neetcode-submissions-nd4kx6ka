class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // int max = -Integer.MAX_VALUE;
        // for(int i = 0; i < piles.length; i++) {
        //     if(piles[i] > max) {
        //         max = piles[i];
        //     }

        // }
        int max = Arrays.stream(piles).max().getAsInt();
        int l = 1;
        int r = max;
        
        while (l < r) {
            int m = l + (r - l) / 2;
            boolean res = canFinish(piles, m, h);
            if(!res) {
                l = m + 1;
            } else {
                r = m;
            }

        }
        return l;
    }

    private boolean canFinish(int[] piles, int k, int h) {
        int totalTime = 0;
        for (int pile : piles) {
            totalTime += (pile + k - 1) / k;
        }
        return totalTime <= h;
    }

}

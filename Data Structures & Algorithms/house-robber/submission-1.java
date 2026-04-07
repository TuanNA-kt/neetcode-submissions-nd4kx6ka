class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;

        if(nums.length == 1) return nums[0];

        int maxUntilIndex = -1;
        int[] maxUntilTwoPrevIndex = new int[2];
        maxUntilTwoPrevIndex[0] = 0;
        maxUntilTwoPrevIndex[1] = nums[0];
        int i = 1;

        while(i <= nums.length - 1) {
            int temp = maxUntilTwoPrevIndex[1];
            int possibleMax = maxUntilTwoPrevIndex[0] + nums[i];

            if(possibleMax > maxUntilTwoPrevIndex[1]) {
                maxUntilTwoPrevIndex[1] = possibleMax;
            }
            maxUntilTwoPrevIndex[0] = temp;
            i++;
        }

        return maxUntilTwoPrevIndex[1];
    }
}

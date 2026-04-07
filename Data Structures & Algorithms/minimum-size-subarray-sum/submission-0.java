class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int l = 0;
        int total = 0;
        for(int r = 0; r < nums.length; r++) {
            total += nums[r];
            while(total >= target) {
                minLength = Math.min(minLength, r - l + 1);
                total -= nums[l];
                l++;
            }
        }

        if(minLength == Integer.MAX_VALUE) return 0;
        else return minLength;
    }
}
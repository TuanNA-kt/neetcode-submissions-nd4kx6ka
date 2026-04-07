class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int l = 0, r = 0;
        int minSum = nums[0];
        int maxSum = nums[0];
        int curSumMin = Integer.MAX_VALUE, curSumMax = Integer.MIN_VALUE;
        int total = 0;
        int n = nums.length;
        int maxNumber = Integer.MIN_VALUE;

        while (l <= r && r < n) {
            maxNumber = Math.max(maxNumber, nums[r]);
            curSumMin = Math.min(0, curSumMin);
            curSumMax = Math.max(0, curSumMax);
            total += nums[r];
            curSumMin += nums[r];
            curSumMax += nums[r];

            r++;
            minSum = Math.min(curSumMin, minSum);
            maxSum = Math.max(curSumMax, maxSum);
        }

        if(total == minSum) return maxNumber;
        else return Math.max(maxSum, total - minSum);
    }
}
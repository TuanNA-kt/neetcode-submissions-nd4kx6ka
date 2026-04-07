class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];
        int begin = nums[0];
        while(true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(fast == slow) break;
        }

        while(fast != begin) {
            fast = nums[fast];
            begin = nums[begin];
        }

        return begin;
    }
}

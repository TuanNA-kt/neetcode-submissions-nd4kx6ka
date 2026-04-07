class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int l = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i - l - 1 == k) {
                set.remove(nums[l]);
                l++;
            }
            if(!set.add(nums[i])) return true;
        }

        return false;
    }
} 
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // Khi i > k, phần tử ở i - k - 1 đã ra ngoài khoảng cách k
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) return true; // trùng trong khoảng k
        }
        return false;
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        return binarySearch(nums, target, l, r);
    
    }

    private int binarySearch(int[] nums, int target, int l, int r) {
        if(l > r) {
            return -1;
        }

        int m = (l + r) / 2;
        
        if(target == nums[m]) {
            return m;
        } else if(target < nums[m]) {
            return binarySearch(nums, target, l, m - 1);
        } else {
            return binarySearch(nums, target, m + 1, r);
        }
    }
}

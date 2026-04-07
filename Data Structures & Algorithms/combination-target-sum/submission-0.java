class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        findCombination(nums, target, 0, 0);
        return res;
    }

    private void findCombination(int[] nums, int target, int index, int currentSum) {
        if(currentSum > target) return;

        if(currentSum == target) {
            res.add(new ArrayList<>(subset));
            return;
        }

        for(int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            currentSum += nums[i];
            findCombination(nums, target, i, currentSum);
            subset.remove(subset.size() - 1);
            currentSum -= nums[i];
        }

    }
}

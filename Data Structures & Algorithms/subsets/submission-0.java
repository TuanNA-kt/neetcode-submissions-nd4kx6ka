class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> subset = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        buildSubsets(nums, subset, 0);
        return res;
    }

    private void buildSubsets(int[] nums, List<Integer> subset, int index) {
        if(index >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        buildSubsets(nums, subset, index + 1);

        subset.remove(subset.size() - 1);
        buildSubsets(nums, subset, index + 1);

        return;
    }
}

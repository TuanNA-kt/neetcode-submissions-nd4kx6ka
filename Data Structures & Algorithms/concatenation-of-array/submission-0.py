class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = [None] * len(nums) * 2
        for i, num in enumerate(nums):
            ans[i] = nums[i]
            ans[i+n] = nums[i]
        return ans
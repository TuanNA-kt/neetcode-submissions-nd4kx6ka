class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int res = 0;
        while(l <= r) {
            int temp = Math.min(heights[l], heights[r]);
            res = Math.max(res, (r - l) * temp);
            if(temp == heights[l]) l++;
            else r--;
        }
        return res;
    }
}

class Solution {
    public void sortColors(int[] nums) {
        int[] arr = new int[3];
        for(int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }

        int index = 0;

        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                nums[index] = i;
                index++;
            }
        }

    }
}
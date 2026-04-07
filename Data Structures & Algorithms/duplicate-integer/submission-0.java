class Solution {

    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> numsMap = new HashMap();
        for(int i : nums) {
            numsMap.put(i, numsMap.getOrDefault(i, 0) + 1);
            if(numsMap.get(i) >= 2) {
                return true;
            }
        }

        return false;
    }
}
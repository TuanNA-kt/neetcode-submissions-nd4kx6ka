class Solution {

    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numsSet = new HashSet();
        for(int i : nums) {
            if(!numsSet.add(i)) return true;
        }

        return false;
    }
}
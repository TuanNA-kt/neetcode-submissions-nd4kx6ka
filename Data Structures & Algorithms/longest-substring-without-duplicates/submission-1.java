class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int l = 0;
        int total = 0;
        Boolean res;

        Set<Character> set = new HashSet<>();
        for(int r = 0; r < s.length(); r++) {
            res = set.add(s.charAt(r));
            if(res == false) {
                while(s.charAt(l) != s.charAt(r)) {
                    set.remove(s.charAt(l));
                    l++;
                }
                l++;
            }

            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        int cnt = 0;
        int res = 0;
        int l = 0;
        int maxFreq = 0;
        int temp;
        Map<Character, Integer> counterMap = new HashMap<>();
        for(int r = 0; r < s.length(); r++) {
            temp = counterMap.compute(s.charAt(r), (key, v) -> v == null ? 1 : v + 1);

            maxFreq = Math.max(temp, maxFreq);
        
            while(r - l + 1 - maxFreq > k) {
                counterMap.compute(s.charAt(l), (key, v) -> v - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}

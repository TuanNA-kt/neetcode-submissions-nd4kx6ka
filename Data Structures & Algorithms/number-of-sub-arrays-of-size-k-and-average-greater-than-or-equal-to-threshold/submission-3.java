class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int total = 0;
        int cnt = 0;
        for(int i = 0; i < arr.length; i++) {
            total += arr[i];
            if(i >= k) {
                total -= arr[i - k];
            }
            if(i >= k - 1) {
                if((total / k) >= threshold) cnt++;
            }
        }

        return cnt;
    }
}
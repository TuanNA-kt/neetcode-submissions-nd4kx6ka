class Solution {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public int findKthLargest(int[] nums, int k) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }

        return minHeap.peek();
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }

}

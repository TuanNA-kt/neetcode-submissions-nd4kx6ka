class KthLargest {
    private Queue<Integer> kSizeMinHeap = new PriorityQueue<>();
    private int heapSize = 0;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }
    
    public int add(int val) {

        if(heapSize >= k) {
            if(val <= kSizeMinHeap.peek()) return kSizeMinHeap.peek();
            kSizeMinHeap.poll();
            heapSize--;
        }

        kSizeMinHeap.offer(val);
        heapSize++;

        return kSizeMinHeap.peek();
    }
}

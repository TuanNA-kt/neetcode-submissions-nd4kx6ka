class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> stonesQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones) {
            stonesQueue.offer(stone);
        }

        while(stonesQueue.size() > 1) {
            int x = stonesQueue.poll();
            int y = stonesQueue.poll();
            int temp = Math.abs(x - y);

            if(temp != 0) {
                stonesQueue.offer(temp);
            }
        }

        if(!stonesQueue.isEmpty()) return stonesQueue.peek();

        return 0;
    }
}

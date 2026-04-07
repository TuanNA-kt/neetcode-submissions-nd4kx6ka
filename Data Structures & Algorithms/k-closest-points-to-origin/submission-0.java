class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pointsQueue = new PriorityQueue<>(
            (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );

        for(int[] point : points) {
            if(pointsQueue.size() >= k) {
                if(calculateDistance(pointsQueue.peek()) > calculateDistance(point)) {
                    pointsQueue.poll();
                    pointsQueue.offer(point);
                }
            } else {
                pointsQueue.offer(point);
            }
        }

        int[][] result = new int[k][2];
        int i = 0;
        while (!pointsQueue.isEmpty()) {
            result[i++] = pointsQueue.poll();
        }
        return result;

    }

    private double calculateDistance(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }
}

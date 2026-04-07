class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();

        // build adjacency list with queues
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            map.computeIfAbsent(course, k -> new LinkedList<>()).offer(prerequisite[1]);
        }

        Set<Integer> visited = new HashSet<>(); // đã xử lý xong
        Set<Integer> onPath = new HashSet<>();  // đang DFS

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, map, visited, onPath)) return false;
        }
        return true;
    }

    private boolean dfs(int course, Map<Integer, Queue<Integer>> map,
                        Set<Integer> visited, Set<Integer> onPath) {
        if (visited.contains(course)) return true;   // course này đã xong
        if (onPath.contains(course)) return false;   // cycle

        onPath.add(course);

        if (map.containsKey(course)) {
            // copy queue để không phá dữ liệu cho các nhánh khác
            Queue<Integer> q = new LinkedList<>(map.get(course));
            while (!q.isEmpty()) {
                int prereq = q.poll();
                if (!dfs(prereq, map, visited, onPath)) return false;
            }
        }

        onPath.remove(course);
        visited.add(course);
        return true;
    }
}
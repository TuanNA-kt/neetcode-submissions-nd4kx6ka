class Graph {
    private Map<Integer, HashSet<Integer>> map;
    public Graph() {
        map = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        if(!map.containsKey(src)) map.put(src, new HashSet<>());
        if(!map.containsKey(dst)) map.put(dst, new HashSet<>());
        map.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if(!map.containsKey(src) || !map.containsKey(dst)) return false;
        return map.get(src).remove(dst);
    }

    public boolean hasPath(int src, int dst) {
        int length = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(src);
        queue.add(src);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int node = queue.poll();
                if(node == dst) return true;
                var set = map.get(node);
                for(int n : set) {
                    if(!visited.contains(n)) {
                        visited.add(n);
                        queue.add(n);
                    }
                }
            }
            length++;
        }
        return false;
    }
}

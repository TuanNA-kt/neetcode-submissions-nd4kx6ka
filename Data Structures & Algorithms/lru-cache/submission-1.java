class LRUCache {
    private Queue<Integer> queue = new LinkedList<>();
    private Map<Integer, Integer> cache = new HashMap<>();
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        // ❗Xóa key cũ khỏi queue để tránh duplicate
        queue.remove(key);
        queue.add(key);

        return cache.get(key);
    }

    public void put(int key, int value) {
        // Nếu key đã có → cập nhật giá trị và đưa xuống cuối queue
        if (cache.containsKey(key)) {
            cache.put(key, value);
            queue.remove(key); // tránh duplicate
            queue.add(key);
            return;
        }

        // Nếu key chưa có và cache đầy → xóa LRU
        if (cache.size() >= capacity) {
            while (!queue.isEmpty()) {
                int lru = queue.poll(); // phần tử cũ nhất
                if (cache.containsKey(lru)) {
                    cache.remove(lru);
                    break;
                }
            }
        }

        cache.put(key, value);
        queue.add(key);
    }
}

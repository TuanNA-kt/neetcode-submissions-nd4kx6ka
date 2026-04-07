class Node {
    int key;
    int value;

    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public Node(int key, int value, Node prev, Node next) {
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}

class LRUCache {
    private Map<Integer, Node> cacheMap;
    private final int capacity;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        left = new Node(0, 0);
        right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        if(cacheMap.containsKey(key)) {
            Node res = cacheMap.get(key);
            remove(res);
            push(res);
            return res.value;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            node.value = value;
            remove(node);
            push(node);
        } else {
            Node newNode = new Node(key, value);
            push(newNode);
            cacheMap.put(key, newNode);
            if(cacheMap.size() > capacity) {
                cacheMap.remove(left.next.key);
                remove(left.next);
            }
        }
        
    }

    private void push(Node node) {
        right.prev.next = node;
        node.next = right;
        node.prev = right.prev;
        right.prev = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

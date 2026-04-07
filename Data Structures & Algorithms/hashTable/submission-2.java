class Node {
    int key;
    int value;

    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class HashTable {
    private int capacity;
    private int size;
    private Node[] table;

    public HashTable(int capacity) {
        this.capacity = capacity;
        table = new Node[capacity];
    }

    public void insert(int key, int value) {
        int index = hash(key);
        if(table[index] != null) {
            Node root = table[index];
            while(root.next != null) {
                if(root.key == key) {
                    root.value = value;
                    return;
                }
                root = root.next;
            }

            if(root.key == key) {
                root.value = value;
                return;
            }
            root.next = new Node(key, value);
        } else {
            table[index] = new Node(key, value);
        }

        size++;
        if(((double)size / capacity) >= 0.5) resize();
    }

    public int get(int key) {
        int index = hash(key);
        if(table[index] != null) {
            Node root = table[index];
            while(root != null) {
                if(root.key == key) {
                    return root.value;
                }
                root = root.next;
            }
        }

        return -1;
    }

    public boolean remove(int key) {
        int index = hash(key);
        if(table[index] != null) {
            Node root = table[index];
            Node prev = null;
            while(root != null) {
                if(root.key == key) {
                    if(prev == null) {
                        table[index] = root.next;
                        root.next = null;
                    } else {
                        prev.next = root.next;
                        root.next = null;
                    }
                    size--;
                    return true;
                }

                prev = root;
                root = root.next;    
            }

            return false;
        }

        return false;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    private int hash(int key) {
        return key % this.capacity;
    }

    public void resize() {
        capacity *= 2;
        Node[] oldTable = this.table;
        this.table = new Node[capacity];
        this.size = 0;
        for(Node node : oldTable) {
            while(node != null) {
                insert(node.key, node.value);
                node = node.next;
            }
        }
    }
}

class TreeNode {
    int key;
    int val;

    TreeNode left;
    TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public TreeNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }
}

class TreeMap {
    private TreeNode root;

    private TreeNode insertNode(TreeNode root, int key, int val) {
        TreeNode temp = new TreeNode(key, val);

        if(root == null || root.key == key) return temp;

        if(root.key > key) root.left = insertNode(root.left, key, val);
        else if(root.key < key) root.right = insertNode(root.right, key, val);

        return root;
    }

    private TreeNode getMinNode(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }

        return root;
    }

    private TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.key < key) root.right = deleteNode(root.right, key);
        else if(root.key > key) root.left = deleteNode(root.left, key);
        else {
            if(root.left == null || root.right == null) {
                if(root.left == null) return root.right;
                else return root.left;
            } else {
                TreeNode minNode = getMinNode(root.right);
                root.key = minNode.key;
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.key);
            }
        }

        return root;
    }

    public TreeMap() {
        this.root = null;
    }

    public void insert(int key, int val) {
        this.root = insertNode(this.root, key, val);
    }

    public int get(int key) {
        TreeNode tempRoot = root;
        while(tempRoot != null) {
            if(key > tempRoot.key) {
                tempRoot = tempRoot.right;
            } else if(key < tempRoot.key) {
                tempRoot = tempRoot.left;
            } else {
                return tempRoot.val;
            }
        }

        return -1;
    }

    public int getMin() {
        if(root == null) return -1;

        TreeNode tempRoot = root;
        while(tempRoot.left != null) {
            tempRoot = tempRoot.left;
        }

        return tempRoot.val;
    }

    public int getMax() {
        if(root == null) return -1;

        TreeNode tempRoot = root;
        while(tempRoot.right != null) {
            tempRoot = tempRoot.right;
        }

        return tempRoot.val;
    }

    public void remove(int key) {
        root = deleteNode(root, key);
    }

    private void inorderDFS(TreeNode root, List<Integer> list) {
        if(root == null) return;

        inorderDFS(root.left, list);
        list.add(root.key);
        inorderDFS(root.right, list);
    }

    public List<Integer> getInorderKeys() {
        List<Integer> list = new ArrayList<>();
        inorderDFS(root, list);
        return list;
    }
}

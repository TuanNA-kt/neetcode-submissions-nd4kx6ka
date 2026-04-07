/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }

        map = new HashMap<>();
        return clone(node);
    }

    private Node clone(Node node) {

        if (map.containsKey(node)) {
            return map.get(node);
        }

        
        Node temp = new Node(node.val);
        map.put(node, temp);
        for(Node n : node.neighbors) {
            if(!map.containsKey(n)) temp.neighbors.add(clone(n));
            else temp.neighbors.add(map.get(n));
        }

        return temp;
    }
}
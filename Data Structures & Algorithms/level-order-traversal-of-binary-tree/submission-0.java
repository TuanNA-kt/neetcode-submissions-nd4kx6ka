/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if(root != null) deque.addFirst(root);

        while(!deque.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int dequeSize = deque.size();
            for(int i = 0; i < dequeSize; i++) {
                TreeNode tempNode = deque.pop();
                temp.add(tempNode.val);
                if(tempNode.left != null) deque.addLast(tempNode.left);
                if(tempNode.right != null) deque.addLast(tempNode.right);
            }
            res.add(temp);
        }

        return res;
    }
}

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> nodeDeque = new ArrayDeque<>();
        if(root != null) nodeDeque.push(root);
    
        while(!nodeDeque.isEmpty()) {
            int levelSize = nodeDeque.size();
            
            for(int i = 0; i < levelSize; i++) {
                TreeNode tempNode = nodeDeque.poll();
                if(i == 0) res.add(tempNode.val);
                if(tempNode.right != null) nodeDeque.offer(tempNode.right);
                if(tempNode.left != null) nodeDeque.offer(tempNode.left);
            }
        }
        
        return res;
    }
}

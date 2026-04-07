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
    private TreeNode findMinNode(TreeNode root) {

        while(root.left != null) {
            root = root.left;
        }

        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if(key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if(key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if(root.left == null || root.right == null) {
                if(root.left == null) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            } else {
                TreeNode minNode = findMinNode(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, root.val);
            }
        }

        return root;
    }
}
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        
        // Chỉ gọi đệ quy, KHÔNG gán kết quả ngay
        if (val > root.val) {
            // Chỉ gán khi node con là null
            if (root.right == null) {
                root.right = new TreeNode(val); // Tạo node mới
            } else {
                insertIntoBST(root.right, val); // Chỉ gọi đệ quy, không gán
            }
        } else {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insertIntoBST(root.left, val);
            }
        }
        return root;
    }
}
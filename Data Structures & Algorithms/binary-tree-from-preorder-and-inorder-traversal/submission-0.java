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
    private int[] preorder;
    private Map<Integer, Integer> rootIndexMapper = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
    
       for(int i = 0; i < inorder.length; i++) {
        rootIndexMapper.put(inorder[i], i);
       }

       return buildTreeHelper(0, 0, preorder.length);
    }

    private TreeNode buildTreeHelper(int inorderStart, int preorderStart, int size) {
        if(size <= 0) return null;
        
        TreeNode root = new TreeNode(preorder[preorderStart]);
        int rootIndex = rootIndexMapper.get(preorder[preorderStart]);
        int leftSubtreeSize = rootIndex - inorderStart;
        root.left = buildTreeHelper(inorderStart, preorderStart + 1, leftSubtreeSize);
        root.right = buildTreeHelper(rootIndex + 1, preorderStart + 1 + leftSubtreeSize, size - 1 - leftSubtreeSize);
        return root;
    }
}

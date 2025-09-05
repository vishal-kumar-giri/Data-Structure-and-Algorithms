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
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE);
    }
    public TreeNode helper(int[] preorder,int bound){
        if(i>=preorder.length || preorder[i]>bound)return null;
        TreeNode root = new TreeNode(preorder[i++]);
        root.left = helper(preorder,root.val);
        root.right = helper(preorder,bound);
        return root; 
    }
}
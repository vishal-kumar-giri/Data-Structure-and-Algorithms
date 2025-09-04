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
    public TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy=new TreeNode(-1);
        curr=dummy;
        inOrder(root);
        return dummy.right;
    }
    public void inOrder(TreeNode root){
        if(root==null)return;
        inOrder(root.left);
        root.left=null;
        curr.right=root;
        curr=root;
        inOrder(root.right);
    }
}
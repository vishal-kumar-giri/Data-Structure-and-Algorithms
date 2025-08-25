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
    public TreeNode invertTree(TreeNode root) {
      if(root==null)return root;
      Queue<TreeNode> queue=new LinkedList<>();
      queue.offer(root);
      while(!queue.isEmpty()){
        TreeNode temp=queue.poll();
        TreeNode tempNode=temp.left;
        temp.left=temp.right;
        temp.right=tempNode;
        if(temp.left!=null)queue.offer(temp.left);
        if(temp.right!=null)queue.offer(temp.right);
      } 
      return root; 
    }
}
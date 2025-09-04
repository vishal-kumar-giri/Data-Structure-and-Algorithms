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
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null)return -1;
        int firstMin=root.val;
        long secondMin=Long.MAX_VALUE;
        secondMin = dfs(root,firstMin,secondMin);
        return (secondMin == Long.MAX_VALUE)?-1:(int)secondMin;
    }
    public long dfs(TreeNode root, int min, long secondMin){
        if(root==null)return secondMin;
        if(root.val>min && root.val<secondMin)secondMin=root.val;
        secondMin = dfs(root.left,min,secondMin);
        secondMin = dfs(root.right,min,secondMin);
        return secondMin;
    }
}
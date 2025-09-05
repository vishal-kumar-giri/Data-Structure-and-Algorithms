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
    int sum=0;
    public int sumNumbers(TreeNode root) {
        getSum(root,0);
        return sum;
    }
    public void getSum(TreeNode root, int curNum){
        if(root==null)return;
        curNum = curNum*10 + root.val;
        if(root.left==null && root.right==null){
            sum +=curNum;
            return;
        }
        getSum(root.left,curNum);
        getSum(root.right,curNum);
    }
}
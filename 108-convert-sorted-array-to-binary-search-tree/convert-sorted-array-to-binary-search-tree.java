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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)return null;
        return getBST(nums,0,nums.length-1);
    }
    public TreeNode getBST(int nums[],int si, int ei){
        if(si>ei) return null;
        int mid=(si+ei)/2;
        TreeNode bst=new TreeNode(nums[mid]);
        bst.left=getBST(nums,si,mid-1);
        bst.right=getBST(nums,mid+1,ei);
        return bst;
    }
}
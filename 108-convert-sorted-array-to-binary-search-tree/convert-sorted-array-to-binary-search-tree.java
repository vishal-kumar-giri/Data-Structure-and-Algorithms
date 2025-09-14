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
        return bst(nums,0,nums.length-1);
    }
    public TreeNode bst(int[]nums,int leftIdx,int rightIdx){
        if(leftIdx>rightIdx)return null;
        int mid = leftIdx+ (rightIdx-leftIdx)/2;
        TreeNode root =new TreeNode(nums[mid]);
        root.left = bst(nums,leftIdx,mid-1);
        root.right = bst(nums,mid+1,rightIdx);
        return root;
    }
}
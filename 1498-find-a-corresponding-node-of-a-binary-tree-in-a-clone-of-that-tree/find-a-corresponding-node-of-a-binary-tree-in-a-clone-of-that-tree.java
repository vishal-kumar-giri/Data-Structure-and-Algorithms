/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode target,result;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.target=target;
        inorder(original,cloned);
        return result;
    }
    public void inorder(TreeNode root,TreeNode cloned){
        if(root==null)return;
            inorder(root.left,cloned.left);
            if(root==target)result=cloned;
            inorder(root.right,cloned.right);
        }
    }

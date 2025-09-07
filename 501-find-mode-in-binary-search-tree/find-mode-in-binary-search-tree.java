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
    List<Integer>ans;
    Integer prev=null;
    int temp=1;
    int mf=1;
    public int[] findMode(TreeNode root) {
        ans=new ArrayList<>();
        inOrder(root);
        int [] res=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }
        return res;
    }
    public void inOrder(TreeNode root){
        if(root==null)return;
        inOrder(root.left);
        if(prev!=null){
            if(root.val==prev){
                temp++;
            }else{
                temp=1;
            }
        }
        prev=root.val;
        if(temp>mf){
            ans.clear();
            ans.add(root.val);
            mf=temp;
        }else if(temp==mf){
            ans.add(root.val);
        }
        inOrder(root.right);
    }
}
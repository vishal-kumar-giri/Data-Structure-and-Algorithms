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
    public boolean isCousins(TreeNode root, int x, int y) {
       if(root==null)return false;
       Queue<TreeNode>queue=new LinkedList<>();
       queue.offer(root);
       int childCount=0;
       while(!queue.isEmpty()){
        int size=queue.size();
        for(int i=0;i<size;i++){
            TreeNode temp = queue.poll();
            int parentCount=0;
            if(temp.left!=null){
                if(temp.left.val==x || temp.left.val==y){
                    parentCount++;
                    childCount++;
                }
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                if(temp.right.val==x || temp.right.val==y){
                    parentCount++;
                    childCount++;
                }
                queue.offer(temp.right);
            }
            if(parentCount==2)return false;
        }
        if(childCount==2)return true;
        if(childCount==1)return false;
       } 
       return false;
    }
}
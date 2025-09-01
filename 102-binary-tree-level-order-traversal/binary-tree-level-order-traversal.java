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
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>>result=new ArrayList<>();

      if(root==null)return result;

      Queue<TreeNode>queue=new LinkedList<>();
      queue.offer(root);
      while(!queue.isEmpty()){
        List<Integer>curr=new ArrayList<>();
        int levelSize=queue.size();
        for(int i=0;i<levelSize;i++){
            TreeNode temp=queue.poll();
            curr.add(temp.val);
            if(temp.left!=null)queue.offer(temp.left);
            if(temp.right!=null)queue.offer(temp.right);
        }
        result.add(curr);
      }  
      return result;
    }
}
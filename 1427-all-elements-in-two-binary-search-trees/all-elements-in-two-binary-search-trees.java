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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
      List<Integer>list1 = new ArrayList<>();
      List<Integer>list2 = new ArrayList<>();

      inOrder(root1,list1);
      inOrder(root2,list2);
      return merge(list1,list2);                
    }
    public void inOrder(TreeNode root,List<Integer>list){
        if(root==null)return ;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
    public List<Integer> merge(List<Integer>list1,List<Integer>list2){
        List<Integer>result = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<list1.size() && j<list2.size()){
            if(list1.get(i)<list2.get(j)){
                result.add(list1.get(i++));
            }else{
                result.add(list2.get(j++));
            }
        }
        while(i<list1.size())result.add(list1.get(i++));
        while(j<list2.size())result.add(list2.get(j++));
        return result ;
    }
}
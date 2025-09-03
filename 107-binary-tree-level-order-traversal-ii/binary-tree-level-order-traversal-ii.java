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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>>result = new LinkedList<>();
        if(root==null)return result;
        Queue<TreeNode>queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer>curr = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp = queue.poll();
                curr.add(temp.val);
                if(temp.left!=null)queue.offer(temp.left);
                if(temp.right!=null)queue.offer(temp.right);
            } 
            result.add(0,curr);
        } 
        return result;
    }
}

// class Solution {
//     public List<List<Integer>> levelOrderBottom(TreeNode root) {
//         List<List<Integer>> result = new LinkedList<>();
//         if (root == null) return result;
        
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);
        
//         while (!queue.isEmpty()) {
//             List<Integer> curr = new ArrayList<>();
//             int size = queue.size();
            
//             for (int i = 0; i < size; i++) {
//                 TreeNode temp = queue.poll();
//                 curr.add(temp.val);
                
//                 if (temp.left != null) queue.offer(temp.left);
//                 if (temp.right != null) queue.offer(temp.right);
//             }
            
//             // Instead of adding at end, we add at the beginning
//             result.add(0, curr);
//         }
        
//         return result;
//     }
// }

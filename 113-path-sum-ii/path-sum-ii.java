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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    public void helper(TreeNode root, int target, List<Integer> path, List<List<Integer>> curr) {
        if (root == null) return;

        path.add(root.val);

        // Check if it's a leaf node and the path sum equals the target
        if (root.left == null && root.right == null && target == root.val) {
            curr.add(new ArrayList<>(path));
        } else {
            helper(root.left, target - root.val, path, curr);
            helper(root.right, target - root.val, path, curr);
        }

        path.remove(path.size() - 1);
    }
}

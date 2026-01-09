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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
    
    private Result dfs(TreeNode root) {
        if (root == null) return new Result(null, 0);
        Result left = dfs(root.left);
        Result right = dfs(root.right);
        if (left.depth == right.depth) return new Result(root, left.depth + 1);
        return left.depth > right.depth ? new Result(left.node, left.depth + 1) : new Result(right.node, right.depth + 1);
    }
    
    private class Result {
        TreeNode node;
        int depth;
        Result(TreeNode n, int d) {
            node = n;
            depth = d;
        }
    }
}

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
    long total = 0;
    long max = 0;
    int MOD = 1000000007;

    public int maxProduct(TreeNode root) {
        totalSum(root);
        dfs(root);
        return (int)(max % MOD);
    }

    private long totalSum(TreeNode node) {
        if (node == null) return 0;
        total += node.val;
        totalSum(node.left);
        totalSum(node.right);
        return total;
    }

    private long dfs(TreeNode node) {
        if (node == null) return 0;
        long left = dfs(node.left);
        long right = dfs(node.right);
        long sub = left + right + node.val;
        max = Math.max(max, sub * (total - sub));
        return sub;
    }
}
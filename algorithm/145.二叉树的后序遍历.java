/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */

// @lc code=start
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        // 解法1：递归
        postorderTraversalRecursive(root, result);
    }

    // 解法1：递归
    private void postorderTraversalRecursive(TreeNode curRoot, List<Integer> result) {
        if (curRoot == null) return;
        
        if (curRoot.left != null) postorderTraversalRecursive(curRoot.left, result);
        if (curRoot.right != null) postorderTraversalRecursive(curRoot.right, result);
        result.add(curRoot.val);
    }
}
// @lc code=end


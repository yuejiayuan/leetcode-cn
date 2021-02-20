/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        // 解法1：递归
        // preorderTraversalRecursive(root, result);
        // 解法2：迭代
        preorderTraversalIteration(root, result);
        return result;
    }

    // 解法1：递归
    private void preorderTraversalRecursive(TreeNode curRoot, List<Integer> result) {
        if (curRoot == null) return;

        result.add(curRoot.val);
        if (curRoot.left != null) preorderTraversalRecursive(curRoot.left, result);
        if (curRoot.right != null) preorderTraversalRecursive(curRoot.right, result);
    }

    // 解法2：迭代
    private void preorderTraversalIteration(TreeNode root, List<Integer> result) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                result.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            cur = cur.right;
        }
    }
}
// @lc code=end


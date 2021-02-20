/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        // 解法1：递归
        // inorderTraversalRecursive(root, result);
        // 解法2：迭代
        inorderTraversalIteration(root, result);
        return result;
    }

    // 解法1：递归
    private void inorderTraversalRecursive(TreeNode curRoot, List<Integer> result) {
        if (curRoot == null) return;

        if (curRoot.left != null) inorderTraversalRecursive(curRoot.left, result);
        result.add(curRoot.val);
        if (curRoot.right != null) inorderTraversalRecursive(curRoot.right, result);
    }

    // 解法2：迭代
    private void inorderTraversalIteration(TreeNode root, List<Integer> result) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
    }
}
// @lc code=end


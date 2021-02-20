/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        if (!isBalanced(root.left)) return false;
        if (!isBalanced(root.right)) return false;

        return (Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1);
    }

    private int getHeight(TreeNode curNode) {
        if (curNode == null) return 0;
        int leftHeight = getHeight(curNode.left);
        int rightHeight = getHeight(curNode.right);
        return (leftHeight >= rightHeight ? leftHeight : rightHeight) + 1;
    }
}
// @lc code=end


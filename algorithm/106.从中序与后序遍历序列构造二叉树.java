/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
 /*                    左子树                   根              右子树        
  *  inorder    -------------------             -          -------------
  *            inS           inIdx-1          inIdx      inIdx+1      inE     
  *
  *                    左子树                       右子树              根  
  *  postorder  -------------------             -------------          -
  *           postS    inIdx-inS+postS  inIdx-inS+postS+1  postE-1   postE
  */
class Solution {
    private HashMap<Integer, Integer> inIdxMap; 

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length <= 0 ||  postorder.length <= 0) {
            return null;
        }

        initInIdxMap(inorder);
        
        return buildTreeRecursive(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private void initInIdxMap(int[] inorder) {
        inIdxMap = new HashMap();
        for (int i = 0; i < inorder.length; ++i) {
            inIdxMap.put(inorder[i], i);
        }
    }

    private TreeNode buildTreeRecursive(int[] inorder, int inS, int inE
            , int[] postorder, int postS, int postE) {
        if (inS > inE || postS > postE) return null;

        TreeNode root = new TreeNode(postorder[postE]);
        int inIdx = inIdxMap.get(postorder[postE]);
        root.left = buildTreeRecursive(inorder, inS, inIdx-1
            , postorder, postS, inIdx-inS+postS-1);
        root.right = buildTreeRecursive(inorder, inIdx+1, inE
            , postorder, inIdx-inS+postS, postE-1);
        return root;
    }
}
// @lc code=end


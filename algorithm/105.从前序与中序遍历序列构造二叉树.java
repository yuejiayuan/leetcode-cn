/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 /*
 * root             左子树                               右子树
 *  -      -------------------------              ---------------------
 * preS   preS+1             inIdx-inS+preS     inIdx-inS+preS+1      preE
 * 
 *           左子树                 root               右子树
 * -------------------------         -         ---------------------
 * inS                  inIdx-1    inIdx    inIdx+1                inE
 * 
 *                       （inIdx通过inorderIdxMap获取）
 */
class Solution {
    private HashMap<Integer, Integer> inorderIdxMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }

        initInorderIdxMap(inorder);

        return buildTreeRecursive(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private void initInorderIdxMap(int[] inorder) {
        inorderIdxMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; ++i) {
            inorderIdxMap.put(inorder[i], i);
        }
    }

    private TreeNode buildTreeRecursive(int[] preorder, int preS, int preE
            , int[] inorder, int inS, int inE) {
        if (preS > preE || inS > inE) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preS]);
        int inIdx = inorderIdxMap.get(preorder[preS]);
        root.left = buildTreeRecursive(preorder, preS+1, inIdx-inS+preS, inorder, inS, inIdx-1);
        root.right = buildTreeRecursive(preorder, inIdx-inS+preS+1, preE, inorder, inIdx+1, inE);

        return root;
    }
}
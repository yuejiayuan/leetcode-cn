/*
 * @lc app=leetcode.cn id=100 lang=c
 *
 * [100] 相同的树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */


bool isSameTree(struct TreeNode* s, struct TreeNode* t){
    if (!s && !t) {
    	return true;
    }

    if ((!s && t) || (s && !t) || (s->val != t->val)) {
     	return false;
    }
    
    return isSameTree(s->left, t->left) && isSameTree(s->right, t->right);
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=572 lang=c
 *
 * [572] 另一个树的子树
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


bool isSameTree(struct TreeNode* s, struct TreeNode* t);
bool dfs(struct TreeNode* s, struct TreeNode* t);

bool isSubtree(struct TreeNode* s, struct TreeNode* t) {
  	return dfs(s, t);
}

bool isSameTree(struct TreeNode* s, struct TreeNode* t) {
    if (!s && !t) {
    	return true;
    }

    if ((!s && t) || (s && !t) || (s->val != t->val)) {
     	return false;
    }
    
    return isSameTree(s->left, t->left) && isSameTree(s->right, t->right);
}

bool dfs(struct TreeNode* s, struct TreeNode* t) {
    if (!s || !t) {
        return false;
    }
  	return isSameTree(s, t) || dfs(s->left, t) || dfs(s->right, t) ;
}
// @lc code=end


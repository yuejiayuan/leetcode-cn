/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        if (height.length < 2) return 0;

        int i = 0 , j = height.length - 1;
        int maxArea = 0;

        while (i < j) {
            maxArea = Math.max(maxArea
                , Math.min(height[i], height[j]) * (j - i));
            if (height[i] > height[j]) {
                --j;
            } else {
                ++i;
            }
        }
        return maxArea;
    }
}
// @lc code=end


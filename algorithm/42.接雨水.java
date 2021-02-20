/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        return trapDP(height);
    }

    // 动态规划
    private int trapDP(int[] height) {
        if (height == null || height.length <= 2) return 0;

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int rain = 0;

        leftMax[0] = height[0];
        for (int i = 1; i < height.length; ++i) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        rightMax[height.length-1] = height[height.length-1];
        for (int i = height.length - 2; i >= 0 ; --i) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        for (int i = 0; i < height.length; ++i) {
            rain += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return rain;
    }
}
// @lc code=end

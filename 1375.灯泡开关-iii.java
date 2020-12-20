/*
 * @lc app=leetcode.cn id=1375 lang=java
 *
 * [1375] 灯泡开关 III
 */

// @lc code=start
class Solution {
    public int numTimesAllBlue(int[] light) {
        int ans = 0;
        int curMax = 0;
        for (int i = 0; i < light.length; i++) {
            curMax = Math.max(curMax, light[i]);
            if (curMax == i + 1) {
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length < 1 || (nums.length == 1 && nums[0] < s)) return 0;
        if (nums.length == 1 && nums[0] >= s) return 1;

        int sp = 0, ep = 0;
        int curSum = 0;
        int result = Integer.MAX_VALUE;
        while (ep < nums.length) {
            curSum += nums[ep];
            while (curSum >= s) {
                result = Math.min(result, ep - sp + 1);
                curSum -= nums[sp];
                ++sp;
            }
            ++ep;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
// @lc code=end


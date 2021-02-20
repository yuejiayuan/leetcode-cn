/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int ans = 0;
        int curMin = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] - curMin > 0) {
                ans = Math.max(ans, prices[i] - curMin);
            }
            curMin = Math.min(prices[i], curMin);
        }

        return ans;
    }
}
// @lc code=end


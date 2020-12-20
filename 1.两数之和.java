/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

import java.util.Map;
import java.util.HashMap;

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            int comp = target - nums[i];
            if (mp.containsKey(comp)) {
                return new int[] {mp.get(comp), i};
            }
            mp.put(nums[i], i);
        }
        throw new IllegalArgumentException("no answer");
    }
}
// @lc code=end


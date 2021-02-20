/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); //java对[]原始数组排序
        int size = nums.length;

        int bestResult = 99999999;
        for(int s = 0; s < size; ++s) {
            int m = s + 1, e = size - 1;
            while (m < e) {
                int curSum = nums[s] + nums[m] + nums[e];
                if (curSum == target) return target;
                if (isBetter(curSum, bestResult, target)) {
                    bestResult = curSum;
                }

                if (curSum > target) 
                    --e;
                } else {
                    ++m;
                }
            }
        }
        return bestResult;
    }

    private boolean isBetter(int curSum, int curBest, int target) {
        return Math.abs(target - curSum) < Math.abs(target - curBest);
    }
}
// @lc code=end


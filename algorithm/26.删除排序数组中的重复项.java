/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;

        int idxBase = 0, idxNext = 1;
        while (idxNext < nums.length) {
            if (nums[idxBase] != nums[idxNext]) {
                ++idxNext;
                ++idxBase;
            } else {
                while (idxNext < nums.length && nums[idxBase] == nums[idxNext]) {
                    ++idxNext;
                }

                if (idxNext == nums.length) {
                    break;
                } else {
                    nums[++idxBase] = nums[idxNext];
                }
            }
        }
        return (idxBase + 1);
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) return nums[0];
        return partition(nums, 0, nums.length - 1, k);
    }

    private int partition(int[] nums, int s, int e, int k) {
        int pivot = nums[s];
        int i = s, j = e;
        while (i < j) {
            while (i < j && pivot > nums[j]) {
                --j;
            }
            if (i < j) {
                nums[i] = nums[j];
                ++i;
            }

            while (i < j && pivot < nums[i]) {
                ++i;
            }
            if (i < j) {
                nums[j] = nums[i];
                --j;
            }
        }
        nums[j] = pivot;

        if (j == k - 1) {
            return nums[k - 1];
        } else if (j < k - 1) {
            // 从右子数组中继续寻找
            return partition(nums, j + 1, e, k);
        } else {
            // 从左子数组中继续寻找
            return partition(nums, s, j - 1, k);
        }
    }
}
// @lc code=end

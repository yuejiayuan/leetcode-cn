/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1 || k == 1) return nums[0];
        return partition(nums, 0, nums.length - 1, k);
    }

    private int partition(int[] nums, int s, int e, int k) {
        int baseVal = nums[s];
        int i = s, j = e;
        while (i < j) {
            while (i < j && baseVal > nums[j]) {
                --j;
            }
            if (i < j) {
                nums[i] = nums[j];
                ++i;
            }

            while (i < j && baseVal < nums[i]) {
                ++i;
            }
            if (i < j) {
                nums[j] = nums[i];
                --j;
            }
        }
        nums[i] = baseVal;

        for (int ii = 0; ii < nums.length; ++ii) {
            System.out.print(nums[ii] + " ");
        }
        System.out.println();

        if (i + 1 == k) {
            return nums[k];
        } else if (i + 1 < k) {
            // 从右子数组中继续寻找
            return partition(nums, i + 1, e, k - (i + 1));
        } else {
            // 从左子数组中继续寻找
            return partition(nums, s, i - 1, (i + 1) - k);
        }
    }
    // k = 4
    // 0 1 2 3 4 5  6 7 
    // 8 6 7 9 5 10 2 1
    //       #              k = 4（对应数组下标为3）
    //   *                  i = 1
    //            *         i = 5
}
// @lc code=end

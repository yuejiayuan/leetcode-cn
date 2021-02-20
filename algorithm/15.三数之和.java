/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); //java对[]原始数组排序
        int size = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int s = 0; s < size; ++s) {
            if (nums[s] > 0) break;
            // 跳过排序后重复的数字
            if (s > 0 && nums[s-1] == nums[s]) continue;

            int target = -nums[s]; //后两个数的目标之和 
            for (int m = s + 1; m < size; ++m) {
                if (nums[m] > target) break;
                if (m > s + 1 && nums[m-1] == nums[m]) continue;

                int e = size - 1;
                while (m < e && nums[m] + nums[e] > target) {
                    --e;
                }
                if (m == e) break;
                if (nums[m] + nums[e] == target) {
                    // 找到一组解
                    ArrayList<Integer> ans = new ArrayList<Integer>();
                    ans.add(nums[s]);
                    ans.add(nums[m]);
                    ans.add(nums[e]);
                    result.add(ans);
                }
            }
        }

        return result;
    }
}
// @lc code=end


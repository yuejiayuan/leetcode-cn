/*
 * @lc app=leetcode.cn id=945 lang=java
 *
 * [945] 使数组唯一的最小增量
 */

// @lc code=start
class Solution {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int result = 0;
        for (int i = 1; i < A.length; ++i) {
            if (A[i-1] >= A[i]) {
                int delta = (A[i-1] + 1) - A[i];
                result += delta;
                A[i] = A[i-1] + 1;
            }
        }
        return result;
    }
}
// @lc code=end


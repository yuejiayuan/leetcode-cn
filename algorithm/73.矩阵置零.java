/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return; 
        boolean firstRowZero = false; // 记录首行是否需要置零
        // 记录是否置零
        for (int r = 0; r < matrix.length; ++r) {
            for (int c = 0; c < matrix[0].length; ++c) {
                if (matrix[r][c] == 0) {
                    if (r == 0) {
                        firstRowZero = true;
                    } else {
                        matrix[r][0] = 0;
                    }
                    matrix[0][c] = 0;
                }
            }
        }
        // 处理行置零
        for (int r = 1; r < matrix.length; ++r) {
            if (matrix[r][0] == 0) {
                for (int c = 0; c < matrix[r].length; ++c) matrix[r][c] = 0;
            }
        }
        // 处理列置零
        for (int c = 0; c < matrix[0].length; ++c) {
            if (matrix[0][c] == 0) {
                for (int r = 0; r < matrix.length; ++r) matrix[r][c] = 0;
            }
        }
        // 处理首行置零
        if (firstRowZero) {
            for (int i = 0; i < matrix[0].length; ++i) matrix[0][i] = 0;
        }
    }
}
// @lc code=end


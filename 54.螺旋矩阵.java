/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) return result;
        
        int[][] dir = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上
        int dirIdx = 0; // 当前下一步要走的方向（数组下标）
        int curRowLen = matrix.length; // 当前剩余行数，方向{0,1}, {0,-1}
        int curColLen = matrix[0].length; // 当前剩余列数，方向{1,0}, {-1,0}
        int curDirLen = curColLen; //  当前方向的待走长度
        int x = 0, y = -1; // 初始化“虚拟起点”
        for (int i = 0; i < matrix.length * matrix[0].length; ++i) {
            // 移动
            if (curDirLen > 0) {
                x += dir[dirIdx][0];
                y += dir[dirIdx][1];
                result.add(matrix[x][y]);
                --curDirLen;
            }
            // 当前方向已走完
            if (curDirLen == 0) {
                if (dirIdx == 0 || dirIdx == 2) {
                   curDirLen = --curRowLen;
                } else if (dirIdx == 1 || dirIdx == 3) {
                    curDirLen = --curColLen;
                }
                // 改方向
                dirIdx = (dirIdx + 1) % dir.length;
            }
            
        }
        return result;
    }
}
// @lc code=end


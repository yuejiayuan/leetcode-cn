/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList();
        for (int i = 0; i < Math.min(numRows, s.length()); ++i) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean direDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            
            if (curRow == 0 || curRow == numRows - 1) {
                direDown = !direDown;
            }
            curRow += (direDown ? 1 : -1);
        }

        // 合成返回结果
        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) sb.append(row);
        return sb.toString();
    }
}
// @lc code=end


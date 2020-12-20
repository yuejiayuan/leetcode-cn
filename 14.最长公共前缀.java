/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        StringBuilder result = new StringBuilder();
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; ++i) {
            minLen = Math.min(minLen, strs[i].length());
        }

        for (int i = 0; i < minLen; ++i) {
            boolean flag = true;
            for (int j = 1; j < strs.length; ++j) {
                if (!(strs[0].charAt(i) == strs[j].charAt(i))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return result.toString();
    }
}
// @lc code=end


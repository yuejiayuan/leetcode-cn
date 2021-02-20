/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() <= 1) return s.length();

        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
        int head = 0, maxLen = 1;
        charMap.put(s.charAt(0), 0);

        for (int tail = 1; tail < s.length(); ++tail) {
            char curChar = s.charAt(tail);
            if (charMap.get(curChar) == null) {
                charMap.put(curChar, tail);
            } else {
                if (head < charMap.get(curChar) + 1) {
                    head = charMap.get(curChar) + 1;
                }
                charMap.put(curChar, tail);
            }

            if (maxLen < tail - head + 1) {
                maxLen = tail - head + 1;
            }
        }
        return maxLen;
    }
}
// @lc code=end


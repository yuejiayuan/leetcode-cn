/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<Integer>();
        if (S == null || S.length() == 0) return result;

        int[] si = new int[26];
        int[] ei = new int[26];
        // 初始化
        for (int i = 0 ; i < 26; ++i) {
            si[i] = ei[i] = -1;
        }
        // 赋值
        for (int i = 0; i < S.length(); ++i) {
            int idx = S.charAt(i) - 'a';
            if (si[idx] == -1 && ei[idx] == -1) {
                si[idx] = ei[idx] = i;
            } else {
                if (i < si[idx]) si[idx] = i;
                if (ei[idx] < i) ei[idx] = i;
            }
        }
        // 扫描并获得结果
        int lastIdx = 0;
        for (int i = 0; i < S.length(); ++i) {
            boolean isTail = true;
            for (int j = 0; j < 26; ++j) {
                if (si[j] == -1 || ei[j] == -1) continue;
                if (si[j]<= i && i < ei[j]) {
                    isTail = false;
                    break;
                }
            }
            if (isTail) {
                result.add(i + 1 - lastIdx);
                lastIdx = i + 1;
            }
        }
        return result;
    }
}
// @lc code=end


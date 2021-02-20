/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        int num1 = n, num2 = n;

        while (true) {
            num1 = transform(num1);
            num2 = transform(num2);
            if (num2 == 1) return true;
            num2 = transform(num2);
            if (num1 == 1 || num2 == 1) return true;
            if (num1 == num2) return false;
        }
    }

    private int transform (int n) {
        int sum = 0;
        while (true) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
            if (n == 0) break;
        }
        return sum;
    }
}
// @lc code=end


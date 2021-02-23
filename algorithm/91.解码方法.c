/*
 * @lc app=leetcode.cn id=91 lang=c
 *
 * [91] 解码方法
 */

// @lc code=start

int numDecodings(char * s) {
    if (s == 0 || strlen(s) == 0) {
       return 0;
    }
    
    int dp[strlen(s)];
    memset(dp, 0, sizeof(dp));
    
    dp[0] = (s[0] == '0' ? 0 : 1);
    for (int i = 1; i < strlen(s); ++i) {
        if (s[i] == '0') {  //  只能s[i-1]s[i]联合解析 
            if (s[i-1] == '1' || s[i-1] == '2') {
                if (i - 2 >= 0) {
                    dp[i] += dp[i-2];
                } else {
                    dp[i] = 1;
                }
            } else {
               dp[i] = 0; 
            }
        } else {  // s[i] == '1'~'9'
            dp[i] += dp[i-1];  // s[i]可以独立解析 
           
            // s[i-1]s[i]联合解析 
            int tmp = (s[i-1] - '0') * 10 + (s[i] - '0');
            if (tmp >= 10 && tmp <= 26) {
               if (i - 2 >= 0)
                    dp[i] += dp[i-2];
               else
                    dp[i] = (dp[i-1] + 1);
            }
        }
    }
    return dp[strlen(s)-1];
}
// @lc code=end


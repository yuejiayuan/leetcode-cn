/*
 * @lc app=leetcode.cn id=22 lang=cpp
 *
 * [22] 括号生成
 */

// @lc code=start
using namespace std;

void dfs(int cur, int n, int leftn, int rightn, string s);
bool isExist(string s);

class Solution {
public:
	vector<string> ans;
	
    vector<string> generateParenthesis(int n) {
		dfs(0, 2*n, n, n, "");
		return ans;
    }
    
    /*
	Param
		leftn: 左括号剩余可以添加的数目 
		rightn: 右括号剩余可以添加的数目
	*/
	void dfs(int cur, int n, int leftn, int rightn, string s) {
		if (cur == n) {
			if (!isExist(s)) {
				ans.push_back(s);
			}
			return;
		}
		
		if (leftn > 0) {
			dfs(cur+1, n, leftn-1, rightn, s+"(");
		}
		if (rightn > 0 && leftn < rightn) {
			dfs(cur+1, n, leftn, rightn-1, s+")"); 
		}
	}
	
	bool isExist(string s) {
		for (size_t i = 0; i < ans.size(); ++i) {
			if (!s.compare(ans[i]))  return true;
		}
		return false;
	}
};

// @lc code=end


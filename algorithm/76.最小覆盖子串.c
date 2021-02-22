/*
 * @lc app=leetcode.cn id=76 lang=c
 *
 * [76] 最小覆盖子串
 */

// @lc code=start


int isSubWindow(int* sfreq, int* tfreq);

char * minWindow(char * s, char * t) {
	if (s == NULL || t == NULL || strlen(s) < strlen(t)) {
		return "";
	}
	
	int sfreq[128];
	int tfreq[128];
	int l, r;
	int minlen = strlen(s) + 1;
	int ansl, ansr; // ansl: ans l, ansr: ans r
	char* ans = "";
	memset(sfreq, 0, sizeof(sfreq));
	memset(tfreq, 0, sizeof(tfreq));
	
	// 初始化tfreq
	for (int i = 0; i < strlen(t); ++i) {
		tfreq[t[i]]++;
	}
	
	l = r = 0;
	ansl = ansr = 0;
	// 滑动窗口的区间：[l, r) 
	while (r < (int)strlen(s)) {
		// s[r]不是t中字符
		if (tfreq[s[r]] == 0) {
			r++;
			continue;
		}
		
		sfreq[s[r]]++;
		r++;
		
		// 若当前滑动窗口是一个符合条件的子区间，则左边界l不断右移、找更优化的解 
		while (isSubWindow(sfreq, tfreq)) {
			if (minlen > r - l) {
				minlen = r - l;
				ansr = r;
				ansl = l; 
			}
			
			if (tfreq[s[l]] == 0) {
				l++;
				continue;
			}
			
			sfreq[s[l]]--;
			l++;
		}
	}
	
	if (minlen == strlen(s) + 1) {
		return "";
	}
	// 构造结果数组 
	ans = (char*)malloc(ansr - ansl + 1);
	memset(ans, 0, ansr - ansl + 1);
	for (int i = ansl; i < ansr; ++i) {
		ans[i-ansl] = s[i];
	}
	ans[ansr - ansl] = 0;
	return ans;
}

int isSubWindow(int* sfreq, int* tfreq) {
	for (int i = 0; i < 128; ++i) {
		if (sfreq[i] < tfreq[i]) 
			return 0;
	}
	return 1;
}

// @lc code=end


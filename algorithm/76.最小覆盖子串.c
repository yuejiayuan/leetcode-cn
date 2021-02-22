/*
 * @lc app=leetcode.cn id=76 lang=c
 *
 * [76] 最小覆盖子串
 */

// @lc code=start

char * minWindow(char * s, char * t) {
	if (s == NULL || t == NULL || strlen(s) < strlen(t)) {
		return "";
	}
	
	int tfreq[128]; // tfreq: freqs of t's chars   
	int sfreq[128]; // tfreq: freqs of s's chars   
	int distance; // 当前滑动窗口与t之间的“差距”(0代表两者相同)
	int l, r;
	int minlen = strlen(s) + 1;
	int ansl, ansr; // ansl: ans l, ansr: ans r
	char* ans = "";
	memset(tfreq, 0, sizeof(tfreq));
	memset(sfreq, 0, sizeof(sfreq));
	
	// 初始化
	for (int i = 0; i < strlen(t); ++i) {
		tfreq[t[i]]++;
	}
	distance = strlen(t); 
	
	l = r = 0;
	ansl = ansr = 0;
	// 滑动窗口的区间：[l, r) 
	while (r < (int)strlen(s)) {
		// s[r]不是t中字符
		if (tfreq[s[r]] == 0) {
			r++;
			continue;
		}
		
		if (sfreq[s[r]] < tfreq[s[r]]) {
			distance--;
		}
		sfreq[s[r]]++;
		r++;
		
		// 若当前滑动窗口是一个符合条件的子区间，则左边界l不断右移、找更优化的解 
		while (distance == 0) {
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
			if (sfreq[s[l]] < tfreq[s[l]]) {
				distance++;
			}
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

// @lc code=end


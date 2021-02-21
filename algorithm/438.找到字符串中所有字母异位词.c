/*
 * @lc app=leetcode.cn id=438 lang=c
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start


/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int isequal(int* sc, int* pc);

int* findAnagrams(char * s, char * p, int* returnSize){
    if (s == NULL || p == NULL || strlen(s) < strlen(p)) {
        *returnSize = 0;
        return NULL;
    }

    int* ans = (int*)malloc(20100 * sizeof(int));
    *returnSize = 0;
    int sc[26]; // s count
    int pc[26]; // p count   
    int sp = 0; // start pointer
    int lens = strlen(s);
    int lenp = strlen(p);
    memset(sc, 0, sizeof(sc));
    memset(pc, 0, sizeof(pc));

	// 初始化 
	for (int i = 0; i < strlen(p); ++i) {
		pc[p[i]-'a']++;
		sc[s[i]-'a']++;
	}
    
    while (sp + lenp <= lens) {
		if (isequal(sc, pc)) {
			ans[*returnSize] = sp; 
			*returnSize += 1;
		}
		
		if (sp + lenp < lens) {
			sc[s[sp]-'a']--;
			sc[s[sp+lenp]-'a']++;
		}
		sp++;
	}
    return ans;
}

int isequal(int* sc, int* pc) {
	for (int i = 0; i < 26; ++i) {
		if (sc[i] != pc[i]) return 0;
	}
	return 1;
}

// @lc code=end


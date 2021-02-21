/*
 * @lc app=leetcode.cn id=567 lang=c
 *
 * [567] 字符串的排列
 */

// @lc code=start


int isequal(int* sc, int* pc);

bool checkInclusion(char * p, char * s){
    if (s == NULL || p == NULL || strlen(s) < strlen(p)) {
        return false;
    }

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
		if (isequal(sc, pc)) return true;
		
		if (sp + lenp < lens) {
			sc[s[sp]-'a']--;
			sc[s[sp+lenp]-'a']++;
		}
		sp++;
	}
    return false;
}

int isequal(int* sc, int* pc) {
	for (int i = 0; i < 26; ++i) {
		if (sc[i] != pc[i]) return 0;
	}
	return 1;
}

// @lc code=end


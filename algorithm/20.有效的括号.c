/*
 * @lc app=leetcode.cn id=20 lang=c
 *
 * [20] 有效的括号
 */

// @lc code=start

bool isLeftBracket(char c);
bool isPair(char left, char right);

bool isValid(char * s){
	char stack[10010];
	int capacity = 0;
	int slen = strlen(s);
	
	for (int i = 0; i < slen; ++i) {
		if (isLeftBracket(s[i])) {
			stack[capacity] = s[i];
			capacity += 1;
		} else {
            if (capacity <= 0) {
				return false; 
			}
			char tc = stack[capacity-1]; // tc: top char
			if (!isPair(tc, s[i])) {
				return false;
			} else {
				capacity -= 1;
			}
		}
	}
	return capacity == 0;
}

bool isLeftBracket(char c) {
	return c == '(' || c == '[' || c == '{'; 
}

bool isPair(char left, char right) {
	return (left == '(' && right == ')')
		|| (left == '[' && right == ']')
		|| (left == '{' && right == '}');
} 

// @lc code=end


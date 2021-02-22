/*
 * @lc app=leetcode.cn id=153 lang=c
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start

int findMin(int* nums, int numsSize){
	if (numsSize == 1) return nums[0];
	int left = 0, right = numsSize - 1;
	int mid;
	
	// 未旋转
	if (nums[left] < nums[right]) return nums[left];
	
	// 旋转过的数组 
	while (left < right) {
		mid = (left + right) / 2;
		// 检查mid是不是变化点 
		if (nums[mid] > nums[mid+1]) return nums[mid+1];
		if (nums[mid-1] > nums[mid]) return nums[mid];
		
		/*
			所有变化点左侧元素 > 数组第一个元素
			所有变化点右侧元素 < 数组第一个元素
		*/
		if (nums[left] < nums[mid]) {
			left = mid + 1;
		} else {
			right = mid;
		}
	} 
	
	return -1;
}

// @lc code=end


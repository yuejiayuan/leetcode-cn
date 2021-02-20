class Solution {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;

        int s = 0, e = nums.length - 1;
        while (s < e) {
            if (isOdd(nums[s]) && isEven(nums[e])) {
                ++s;
                --e;
            } else if (isEven(nums[s]) && isOdd(nums[e])) {
                swap(nums, s, e);
                ++s;
                --e;
            } else if (isOdd(nums[s]) && isOdd(nums[e])) {
                ++s;
            } else {
                --e;
            }
        }

        return nums;
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }

    private boolean isOdd(int num) {
        return num % 2 == 1;
    }

    private void swap(int[] nums, int s, int e) {
        int temp = nums[s];
        nums[s] = nums[e];
        nums[e] = temp;
    }
}
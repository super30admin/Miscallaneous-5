class Solution {
    public int longestOnes(int[] nums, int k) {
        // Tc: O(n) Sc: O(1)
        int left = 0, right = 0, maxOnes = 0, zeros = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            maxOnes = Math.max(maxOnes, right - left + 1);
            right++;
        }
        return maxOnes;
    }
}

/*
 * class Solution {
 * // Tc: O(n^2) Sc: O(1)
 * public int longestOnes(int[] nums, int k) {
 * if (nums == null || nums.length == 0)
 * return 0;
 * int ones = 0;
 * for (int i = 0; i < nums.length; i++) {
 * int zeros = 0;
 * for (int j = i; j < nums.length; j++) {
 * if (nums[j] == 0) {
 * zeros++;
 * }
 * if (zeros <= k) {
 * ones = Math.max(ones, j - i + 1);
 * } else {
 * break;
 * }
 * }
 * }
 * return ones;
 * }
 * }
 * 
 */
// Approach: Sliding window using left and right pointers
// Time: O(n)
// Space: O(1)

class Max_Consecutive_Ones {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int max = 0;
        int zeros = 0;

        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 0; i<nums.length; i++) {

            // Increase count of Zeros whenever you see one
            if (nums[i] == 0) {
                zeros++;
            }

            // Shrink the window until zeros are equal or less than required k
            while (left <=i && zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            // At every step record the max size of valid window
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
//TC : O(2N)
//SC : O(N)
class Solution {
    // Using Sliding window
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxConsecutiveOnes = 0;
        int low = 0;
        int countOfZeroes = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                countOfZeroes++;
                if (countOfZeroes > k) {
                    // skip the first zero
                    while (nums[low] != 0) {
                        low++;
                    }
                    low++;
                    countOfZeroes--;
                }
            }
            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, (i - low + 1));
        }
        return maxConsecutiveOnes;
    }
}
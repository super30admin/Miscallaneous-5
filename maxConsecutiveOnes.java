// Bruteforce:
//TC: O(n^2)
//SC: O(1)
class Solution {
    public int longestOnes(int[] nums, int k) {
    if(nums == null || nums.length == 0)
        return 0;
    int maxOnes = 0;
    for (int i = 0; i < nums.length; i++) {
        int zeros = 0;
        for (int j = i; j < nums.length; j++) {
            if (nums[j] == 0) {
                zeros++;
            }
            if (zeros <= k) {
                maxOnes = Math.max(maxOnes, j - i + 1);
            } else {
                break;
            }
        }
    }
    return maxOnes;

    }
}




//TC: O(n)
//SC: O(1)
class Solution {
    public int longestOnes(int[] nums, int k) {
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

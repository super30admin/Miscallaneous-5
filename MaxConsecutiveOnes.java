// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int left = 0;
        int m = k;

        for (int i=0; i< n; i++) {
            if(nums[i] == 0) {
                m--;
            }

            if(m <0) {
                if (nums[left] == 0) {
                    m++;
                }
                left++;
            }
        }

        return n - left;
    }
}
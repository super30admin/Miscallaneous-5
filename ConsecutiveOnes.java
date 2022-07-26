public class ConsecutiveOnes {
    // Once we find out the window, we never shrink the window i.e. once we find out the expected number of 1's
        // with given k's, we don't shrink the window
    // TC : O(n)
    // SC : O(1)
    public int longestOnes(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;

        int left = 0;
        for (int num : nums) {
            if (num == 0) {
                k--;
            }

            if (k < 0) {
                if (nums[left] == 0) { // one zero fallen out of the window, need to increase the value of k
                    k++;
                }
                left++;
            }
        }

        return nums.length - left;
    }
}

// LC 1004
// Maintain max Sliding Window
public class ConsecutiveOnes {

    /**
     * TC: O(2n); worst case all 0's and k = 0 --> visiting each num twice
     * SC: O(1)
     *
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes(int[] nums, int k) {
        int start = 0, end = 0;
        int n = nums.length;
        int max = 0;
        int count0 = k;
        while (end < n) {
            if (nums[end] == 0) {
                if (count0 > 0) {
                    count0--;
                } else if (k > 0) {
                    // update start to a non-zero point
                    while (start < end && nums[start] != 0) {
                        start++;
                    }
                    start++;
                } else {
                    // k == 0
                    // update start to a non-zero point, i.e., current index (end) + 1
                    // to make current length = 0
                    start = end + 1;
                }
            }
            int length = end - start + 1;
            max = Math.max(max, length);
            end++;
        }
        return max;
    }

    /**
     * TC: O(n)
     * SC: O(1)
     * <p>
     * Maintain the sliding window of max length;
     * modify the start when the window is invalid in order to maintain the valid max length window
     * <p>
     * NOTE: Since we maintain the max window. hence, we've the answer with us.
     * no need to maintain and compare max at each index.
     *
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes_fixedSlidingWindow(int[] nums, int k) {
        int start = 0, end = 0;
        int n = nums.length;
        int count0 = k;
        while (end < n) {
            // check for incoming 0 in the window
            if (nums[end] == 0) {
                count0--;
            }
            // modify start if incoming num results in more 0 count in the current window
            if (count0 < 0) {
                // modify my start to maintain the max window size
                if (nums[start] == 0) {
                    // check for outgoing num from the window
                    // we've removed a 0 from the current window
                    count0++;
                }
                start++;
            }
            end++;
        }
        return n - start;
    }
}

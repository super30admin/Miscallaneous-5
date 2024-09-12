public class MaxConecutiveOnes3 {
    /**
     * Sliding widow technique
     * start and end points to index 0.
     * end moves as long as we encounter 1 or we still have K to flip.
     * everytime we flip 0 e reduce k by 1.
     Time complexity - o(n)
     Space Complexity - 0{1)}
     *
     *
     *
     *
     *
     */
    public int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                k--;
            }
            if (k < 0) {
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }
        }
        return nums.length - left;
    }
}

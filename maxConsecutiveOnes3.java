// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Use sliding window algorithm
// we have two pointers i and j, j will be our fast pointer and we run a while loop till the end of the nums length
// we move j when the value is 1, when nums[j]==0 we check if k > 0, then we decrement k and increment j, which means we are flipping 0->1
// when nums[j] == 0 and k == 0 (exhausted all the flips), we update the max value, if (nums[i] == 0) we increase k and then increment i
// at the end when j comes out of the nums array, we check for the max again and return max
class Solution {
    public int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int i=0, j=0, max = Integer.MIN_VALUE;

        while (j<nums.length) {
            if (nums[j] == 1) {
                j++;
            }
            else if (nums[j] == 0 && k > 0) {
                k--;
                j++;
            }
            else if (nums[j] == 0 && k == 0) {
                max = Math.max(max, j-i);
                if (nums[i] == 0) {
                    k++;
                }
                i++;
            }
        }

        return Math.max(max, j-i);
    }
}
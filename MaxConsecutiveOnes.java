// Time Complexity :O(2n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No
class Solution {
    public int longestOnes(int[] nums, int k) {
        int p1 = 0;
        int p2 = 0;
        int max = Integer.MIN_VALUE;
        while (p2 < nums.length) {
            // decrease k if zero found
            if (nums[p2] == 0) {
                k--;
            }
            if (k < 0) {
                // if k goes out of allowed range, increase p1 to exit one zero
                while (nums[p1] != 0) {
                    p1++;
                }
                k++;
                p1++;
            }
            // take maximum length
            max = Math.max(max, p2 - p1 + 1);

            p2++;
        }
        return max;
    }
}

// one pass solution
// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public int longestOnes(int[] nums, int k) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            // if we found a zero, decrease one k
            if (nums[i] == 0) {
                k--;
            }
            if (k < 0) {// if k is negative, increment slow to exclude zero
                if (nums[slow] == 0) {// if we are excluding a zero, increment k
                    k++;
                }
                slow++;
            }
        }
        return nums.length - slow;
    }
}
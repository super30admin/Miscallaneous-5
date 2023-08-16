/**
 * Time Complexity (TC): O(n) 
 * Space Complexity (SC): O(1).
 */

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0 ;
        int max = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) k--;
            if (k < 0) {
                // Move the left pointer till we are not escaping zero
                while (left <= i && nums[left] == 1) {
                    left++;
                }
                left++;
                k++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}


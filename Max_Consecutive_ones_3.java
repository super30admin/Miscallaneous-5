// Time Complexity : O(n) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int longestOnes(int[] nums, int k) {
        if(nums.length == 0 || nums == null){
            return 0;
        }

        int start = 0;
        for(int i = 0; i< nums.length; i++){
            int n = nums[i];
            if(n == 0){
                k--;
            }
            if(k<0){
                if(nums[start]==0){
                    k++;
                }
                start++;
            }
        }
        return (nums.length - start);
    }
}
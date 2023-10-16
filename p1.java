// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int longestOnes(int[] nums, int k) {
        int slow = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                count++;
            }
            if(count > k){
                if(nums[slow] == 0){
                    count--;
                }
                slow++;
            }
        }
        return nums.length-slow;
    }
}
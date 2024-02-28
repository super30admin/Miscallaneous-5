// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution {
    public int longestOnes(int[] nums, int k) {
        int count = k;
        int slow = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                count--;
            if(count < 0){
                if(nums[slow] == 0)
                    count++;
                slow++;
            }
        }
        return nums.length - slow;
    }
}
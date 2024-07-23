// Time Complexity : O(2N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int longestOnes(int[] nums, int k) {
        int max=0;
        int slow=0;
        for(int i=0;i< nums.length;i++){

            if(nums[i] == 0) {
                k--;
            }

            if(k < 0) {
                while(nums[slow] != 0){
                    slow++;
                }
                slow++;
                k++;
            }

            max = Math.max(max, i-slow+1);
        }

        return max;
    }
}

// TC : O(N)
class Solution {
    public int longestOnes(int[] nums, int k) {
        int slow=0;
        for(int i=0;i< nums.length;i++){

            if(nums[i] == 0) {
                k--;
            }

            if(k < 0) {
                if(nums[slow] ==0)k++;
                slow++;

            }
        }

        return nums.length - slow;
    }
}
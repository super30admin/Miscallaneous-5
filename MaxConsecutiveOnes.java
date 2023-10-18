// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class MaxConsecutiveOnes {
    public int longestOnes(int[] nums, int k) {
        int slow = 0;
        int count = 0;
        int max = 0;
        for(int i=0; i< nums.length; i++){

            if(nums[i] == 0) count++;

            if(count <= k){
                max = Math.max(max, i-slow+1);
            }else{
                if(nums[slow] == 0) count--;
                slow++;
            }
        }

        return max;
    }
}
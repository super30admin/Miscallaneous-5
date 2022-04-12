// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class MaxConsecutiveOnes3 {

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) k--;
            if(k < 0){
                //slide from left
                if(nums[left] == 0) k++;
                left++;
            }
        }
        return nums.length - left;
    }
}

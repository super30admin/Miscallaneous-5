package DataStructure.SlidingWindow;

// Time Complexity : Add : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        longestOnes(nums, k);
    }

    public static int longestOnes(int[] nums, int k) {

        int left = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0) k--;

            if(k<0){
                if(nums[left] == 0){
                    k++;
                }
                left++;
            }
        }

        return nums.length - left;
    }
}


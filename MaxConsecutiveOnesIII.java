class Solution {

    //Time Complexity : 0(n) where n is the no. of elements in nums array
    //Space Complexity: 0(1)

    //I have used a variation of sliding window technique

    public int longestOnes(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int left = 0;   //initiallu left pointer is set at 0
        int i = 0;  //i acts as my right pointer
        for(; i < nums.length; i++){
            if(nums[i] == 0){   //if nums of right pointer is 0
                k--;    //then I reduce my k of not, then I just move right pointer forward
            }
            if(k < 0){  //if k becomes less than 0
                if(nums[left] == 0){    //then I check if nums of left pointer is 0
                    k++;    //I increase my k.
                }
                left++; //and then only move my left pointer forward if k is less than 0
            }
        }

        return i - left;    //at the end, the length between my right and left pointer wil give me the max length of consecutive ones
    }
}
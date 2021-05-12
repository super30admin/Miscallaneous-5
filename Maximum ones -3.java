//time complexity-O(n)
//Space complexity-O(1)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int count=0;
        
        for(int right=0;right<nums.length;right++){//sliding window to check the length of possible ones
            if(nums[right]==0)
                k--;
            if(k<0){//if we exhaust limit of number of zeroes we check the length
                if(nums[left]==0)
                    k++;
                left++;
            }
            count= Math.max(count,right-left+1);
        }
        
        return count;
    }
}
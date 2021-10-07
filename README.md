# Misc-5

## Problem 1: Find Consecutive Ones(https://leetcode.com/problems/max-consecutive-ones-iii/)

//time complexity = O(N)
//space complexity = O(1)
class Solution {
    public int longestOnes(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0; 
        int i = 0; 
        int j = 0;
        
        while(i < nums.length){
            if(nums[i] == 0){
                k--; 
            }
            if(k < 0){
                if(nums[j] == 0) k++; 
                j++; 
            }
            i++;
        }
        
        return nums.length - j; 
    }
}
## Problems 2 : Remove all the continuous character

Given a string we have to remove all the continuous character whose count is more than 2.
For example :
1. abba ----> abba
2. abbb---->a is the output because c count is 3.
3. abbbaa---> '' empty string
4. abbacccaa--->abbHere relative order of characters and their counts must be maintained so we figured out that we cannot use hashtable.
Give a solution better than O(n^2).
 


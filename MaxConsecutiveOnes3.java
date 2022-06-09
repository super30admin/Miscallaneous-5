// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Take two pointers and use sliding window technique
// Increment the count of numZero when p2 is 0
// When numZero becomes greater than k, increment p1 till we get 0 at p1
// Keep track of max and finally return the max at the end
class Solution {
    public int longestOnes(int[] nums, int k) {
        int p1 = 0, p2 = 0;
        int numZero = 0;
        int max = 0;
        while(p2 < nums.length){
            if(nums[p2] == 0){
                numZero++;
            }
            while(numZero > k){
                if(nums[p1] == 0)
                    numZero--;
                p1++;
            }
            p2++;
            max = Math.max(max, p2 - p1);  
        }
        return max;
    }
}
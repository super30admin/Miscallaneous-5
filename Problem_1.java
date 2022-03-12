// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// decrese the k count when found 0, then if the k < 0, then check if the left value is 0, if yes then increase the k, else just move the left ( increase left by one)
// Your code here along with comments explaining your approach
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left =  0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) k--;
            if(k < 0){
                if(nums[left] == 0) k++;
                left++;
            }
        }
        return nums.length - left;
    }
}

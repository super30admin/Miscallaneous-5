// Time: O(N) | Space: O(1)

class Solution {
    public int longestOnes(int[] nums, int k) {
        int slow = 0;
        int max = Integer.MIN_VALUE;
        for(int fast = 0; fast< nums.length; fast++) {
            if(nums[fast] == 0) k--;
            if(k < 0) {
                if(nums[slow] == 0)
                    k++;
                slow++;
            }
            max = Math.max(max, fast-slow+1);
        }
        return max;
    }
}
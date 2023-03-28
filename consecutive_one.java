class Solution {
    public int longestOnes(int[] nums, int k) {
        int a = 0;
        int i;
        for(i=0;i<nums.length;i++){
            if(nums[i] == 0) k--;
            if(k<0 && nums[a++] == 0) k++;
        }
        return i-a;
    }
}
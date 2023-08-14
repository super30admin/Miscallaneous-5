//T: O(2n) worst case
//S: O(1) 
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right;
        for(right = 0; right < nums.length; right++){
            if(nums[right] == 0) k--;
            if(k < 0){
                if(nums[left] == 0) k++;
                left++;
            }
        }
        return right-left;
    }
}

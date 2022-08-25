//Time complexity: O(n)
//space complexity: O(1)
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int i;
        for(i=0;i<nums.length;i++)
        {
 
                if(nums[i]==0)
                    k--;

                if(k<0){
                    if(nums[left]==0)k++;
                    left+=1;
                }
            
            
        }
        return i-left;
    }
}
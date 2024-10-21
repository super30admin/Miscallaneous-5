/*
TC --> O(n)
SC --> O(1)
*/
class Solution {
    public int longestOnes(int[] nums, int k) {
        int s = 0;
        int l = 0;
        int max_size = 0;
        while(l<nums.length){
            if(nums[l]==1){
                l++;
            }
            else{
                k--;
                while(k<0){
                    if(nums[s]==0){
                        k++;
                    }
                    s++;
                }
                l++;
            }

            max_size = Math.max(l-s,max_size);
        }//while

        return max_size;
        
    }
}
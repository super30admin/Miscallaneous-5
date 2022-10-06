/*
Time: O(2n) -- > O(n)
Space: O(1)
Executed Sucessfully: Yes
when we encounter a zero, we can move slow pointer till it encounters zero + 1
*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int s = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                k--;
            }
            if (k == -1){
                while (nums[s] != 0){
                    s++;
                }
                s++;
                k = 0;
            }
            res = Math.max(res, i-s+1);
        }
        
        return res;
    }
}


/*
Time: O(n)
Space: O(1)
Executed Sucessfully: Yes
It gives the max consecutive length in intelligent style (still it is a sliding window)
*/


class Solution {
    public int longestOnes(int[] nums, int k) {
        int s = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                k--;
            }
            if(k < 0){
                if (nums[s] == 0){
                    k++;
                }
                s++;
            }
        }
        return nums.length - s;
    }
}

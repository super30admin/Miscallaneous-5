/*

The question is asking that we have only 0s and 1s in an array, and we are a gvien an integer k , which we can use to flip a zero into 1

we need to get the length of  maximum consecutive 1s we can form with/without flipping at most k 0 

Intuition:

This approach is a classic sliding window approach , where we have a start and end pointer. 
We will keep increasing the end pointer , and if end encounters any 0 , we will decerement the avaialble k at that time.  and keep recording length as long as k>=0
as soon as our k becomes less than 0 i.e k = -1, now its time to get rid one 0 from the start, so we will keep increasing the start until it gets past one 0 . we then gain a k back which would make our k=0 and we will continue in that pattern

Time : O(n)
Space: O(1)

*/

class Solution {
  // O(n)
    public int longestOnes(int[] nums, int k) {

        int max = 0;
        int s =0, e=0;
        int rem = k;

        while(e<nums.length){
            if(nums[e] == 0){ // if end encountered 0 then decrement the k
                rem--;
            }
            if(rem < 0){
                if(nums[s] == 0){
                    rem++;
                }
                s++;
            }

            if(rem>=0){
            max = Math.max(max, e-s+1); // record the length and save maxw
            }
            e++;
        }

        return max;
        
    }
      //Time : O(2n)
    private int unOptimized(int[] nums, int k){
                int max = 0;
        int s =0, e=0;
        int rem = k;

        while(e<nums.length){
            if(nums[e] == 0){ // if end encountered 0 then decrement the k
                rem--;
            }
            if(rem < 0){
                // we gotta get rid of one zero from the start
                while(nums[s]!=0){ // keep moving s until it encounter 0
                    s++;
                }
                s++; // now get past that 0
                rem++;// we just got past the k, so we gained another k

            }
            max = Math.max(max, e-s+1); // record the length and save maxw
            e++;
        }

        return max;
    }
}
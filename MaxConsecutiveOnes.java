// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public int longestOnes(int[] A, int K) {
        
        if(A == null || A.length == 0) return 0;
        
        int left = 0;
        
        for(int i = 0; i < A.length; i++) {
            if(A[i] == 0) {
                K--;
            }
            if(K < 0) {
                if(A[left] == 0) {
                    K++;
                }
                left++;
            }
        }
        return A.length - left;
    }
}
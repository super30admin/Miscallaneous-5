// Time Complexity : O(N)
// Space Complexity : O(1)
// Passed Leetcode

class Solution {
    public int longestOnes(int[] A, int K) {
        
        int counter = K;
        
        int maxLength = -1;
        
        int start = 0, end = 0;
        for (int i = 0; i < A.length; i++) {
            end++;
            if (A[i] == 0) {
            
                counter--;
                
                if (counter < 0) {
                    maxLength = Math.max(maxLength, end - start - 1);
                    while(counter < 0) {
                        if (A[start] == 0) 
                            counter++;
                        start++;
                    }
                    
                }
            }
        }
        
        return Math.max(maxLength, end - start);
        
    }
}
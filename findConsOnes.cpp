//Time:O(n) where n is the size of the nums
//Space: O(1) No extra space
class Solution {
public:
    int longestOnes(vector<int>& A, int K) {
        int zeroCount = 0, l = 0;
        int maxLen = 0;
        for( int r = 0 ; r < A.size() ; ++r ) {
            if( A[ r ] == 0 ) ++zeroCount;
            if( zeroCount > K ) {
                if( A[ l ] == 0 ) --zeroCount;
                ++l;
            }
            maxLen = max( maxLen, r - l + 1 );
        }
        return maxLen;
    }
};
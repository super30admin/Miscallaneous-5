//Time - O(n)
//Space - O(1)
class Solution {
public:
    int longestOnes(vector<int>& A, int K) {
        int i = 0,j = 0;
        int ans = 0;

        while(j<A.size()){
            
            if(A[j] == 0){
                K--;
                if(K<0){
                    while(K<0){
                        if(A[i] == 0) K++;
                        i++;
                    }
                }
            }
            if(K>=0){
                ans = max(ans, j-i+1);
            }
            j++;
            
        }
        
        return ans;
        
    }
};
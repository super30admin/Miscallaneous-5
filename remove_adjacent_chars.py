# Approach - Since we are dealing with continous characters and checking for adjacent chars where order is important we use stack
# Time - O(N)
# Space - O(N) stack is used
# https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:

        if not s or len(s) == 0:
            return s
        
        st = []
        
        for char in s:
            
            if st and st[-1][0] == char:
               
                st[-1][1] += 1
                
                if st[-1][1] == k:
                    st.pop()
                    
                    
            else:
                st.append([char, 1])
        
       
        result = ""

        for val in st: # popping from stack will not maintain order so we can iterate over the stack instead
            
            char, freq = val
            result += char * freq
        
        return result
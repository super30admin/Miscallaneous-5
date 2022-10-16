# Time Complexity : O(N) where N is length of the string
# Space Complexity : O(N) where N is length of the string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        stk = []
        i = 0
        stk.append((s[0], 1))
        result = ""
        for i in range(1,len(s)):
            if len(stk) > 0 and stk[-1][0] == s[i]:
                count = stk[-1][1]
                stk.pop()
                if count < k-1:
                    stk.append((s[i], count + 1))
            else:
                stk.append((s[i], 1))
        
        for i in range(len(stk)):
            result += (stk[i][0] *  stk[i][1])
        
        return result
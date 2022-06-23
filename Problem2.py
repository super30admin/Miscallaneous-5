#Time Complexity: O(N)
#Space Complexity: O(N)
class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        stack = []
        for i in s:
            if stack and i == stack[-1][0]:
                stack[-1][1] = stack[-1][1] + 1
            else:
                stack.append([i,1])

            if stack[-1][1] == k:
                stack.pop()

        strr = ""
        for i,j in stack:
            strr += i[0] * j
            
        return strr
                
            
class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        stack=[]
        stack.append([s[0],1])
        for i in range(1,len(s)):
            curr=s[i]
            
            if stack and stack[-1][0]==curr:
                stack[-1][1]+=1
                if stack[-1][1]==k:
                    stack.pop()
            else:
                stack.append([curr,1])

        return ''.join(c*s for c,s in stack)
            
        
#approach
#maintain stack and push thecharacters and its count if the count is equal to the k pop the elements and return the reverse stack as tring


#Complexities
#Time: O(N)
#Space: O(N)




class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        stack = []

        for char in s:
            if stack and stack[-1][0]==char:
                (c, count) = stack.pop()
                if count+1 ==k:
                    continue
                else:
                    stack.append((c,count+1))

            else:
                stack.append((char,1))

        return "".join(c * count for c, count in stack)
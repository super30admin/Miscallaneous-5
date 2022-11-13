# Time complexity : O(n)
# Space complexity : O(n)
# Leetcode : Solved and submitted

class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        # have two stacks, one for char and other for count
        stack, count = [], []
        
        # traverse through the array
        for i in range(len(s)):
            ch = s[i]
            
            # check if the stack is not empty and top of the stack is same as the current char
            if stack and stack[-1] == ch:
                # then update the count of the top of the stack
                cnt = count.pop()
                
                # if the count of char is equal to k, then remove the char from top of stack
                if cnt + 1 == k:
                    stack.pop()
                else:
                    # else update the count on top of stack
                    count.append(cnt + 1)
            else:
                # if a new char has been encountered, then append the char to stack with count as 1
                stack.append(ch)
                count.append(1)
                
        # now move the chars in stack to a res string
        res = ''
        while stack:
            # remove char from the stack starting with 0th index and multiply it with count which will always be less than k
            char, cnt = stack.pop(0), count.pop(0)
            res += char * cnt
        
        # return the res
        return res

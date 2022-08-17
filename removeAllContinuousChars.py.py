'''
Time Complexity: 0(n)
Space Complexity: 0(n)
Run on LeetCode: Yes
'''
class Solution:
    def getSolution(self,string,k):
        
        # initialize a stack
        stack = []
        
        # iterate the string
        for char in string:
            # len == 0
            if len(stack) == 0:
                stack.append([char,1])
                continue
            
            # logic-case
            elif stack[-1][0] == char:
                stack[-1][1] += 1
                
                if stack[-1][1] == k:
                    # pop from the stack
                    stack.pop()
            else:
                stack.append([char,1])
        '''end of for loop'''
        
        # return the newString
        newString = ''
        
        while len(stack) != 0:
            pair = stack.pop()
            for count in range(0,pair[1]):
                newString = str(pair[0]) + newString
        
        # print('newString is:\t',newString)
        return newString

sol = Solution()
print(sol.getSolution("deeebbcccbdaa",3))
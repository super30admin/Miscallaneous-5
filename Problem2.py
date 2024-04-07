'''
1. Maintain a stack of the character and its count. Start traversing the string
2. For each character if the stack is empty or character doesn't match the top element initialize count 1 and push to stack 
3. If character matches the top ele, increment count. If count is greater than 2 pop. Create string by taking elements and counts from stack.

TC: O(n)
SC: O(n) 
'''

def removeExcessCharacters(s):
    if not s or len(s) == 0:
        return ''
    
    stack = []
    for char in s:
        if not stack or char != stack[-1][0]:
            stack.append([char,1])
        else:
            stack[-1][1] += 1
            while len(stack) >= 2 and  stack[-1][1] > 2:
                stack.pop()

    return ''.join(i*j for i,j in stack if j <= 2)

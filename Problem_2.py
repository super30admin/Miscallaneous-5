"""
Time Complexity : O(n)
Space Complexity : O(n)  
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Here, I am just maintaining a stack. If stack is empty, just append the char with count 1. If stack not empty, then we have 2 
conditions, the top char on stack can either match the current char or not. If it does match, I just fetch the count, increment
it and append on top of the stack. In case, it does not match, we have some tasks to do. We need to check count of top char on stack.
if it is more than threshhold, we have to pop it out altogether. After doing this, the current char can still match top of the stack
or not. If not, we just append it. If it matches, we have to do the whole process again, so i just wrote continue, as it again needs
to do all of the above tasks. After we process everything, the char on top of the stack still can have count more than threshold.
If yes, we need to pop out those occurances. After that, we just need to return the chars in the stack.
"""


def removeContinuous(word, k):
    if not word:
        return word

    n, i = len(word), 0
    stack, result = [], []

    while i < n:
        if stack and stack[-1][0] == word[i]:
            count = stack[-1][1]+1
            stack.append((word[i], count))
        else:
            if stack and stack[-1][0] != word[i]:
                count = stack[-1][1]
                if count > k:
                    while count != 0:
                        stack.pop()
                        count -= 1
                if word[i] == stack[-1][0]:
                    continue
                else:
                    stack.append((word[i], 1))
            else:
                stack.append((word[i], 1))
        i += 1

    if stack and stack[-1][1] > k:
        count = stack[-1][1]
        while count != 0:
            stack.pop()
            count -= 1

    for w, c in stack:
        result.append(w)
    return ''.join(result)


k = 2
print(removeContinuous('abba', k))
print(removeContinuous('abbb', k))
print(removeContinuous('abbbaa', k))
print(removeContinuous('abbacccaa', k))
print(removeContinuous('abbaccccaa', k))
print(removeContinuous('abbbaccccaa', k))

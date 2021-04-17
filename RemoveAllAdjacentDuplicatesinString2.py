# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Stack to store incoming elements


class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        if not s:
            return None
        count = 1
        stack = [(s[0], count)]
        for i in range(1, len(s)):
            if stack:
                if stack[-1][1] == k:
                    stack.pop()
                count = 1

            if stack and stack[-1][0] == s[i]:
                str, count = stack.pop()
                count += 1
            stack.append((s[i], count))

        res = []
        for i in range(len(stack)):
            str, count = stack.pop()
            if count == k:
                continue
            res.append(str * count)
        return ''.join(res[::-1])

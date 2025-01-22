"""
Input: s = "deeeddbbcccbdaa", k = 3
Brute force: once we find k continuous ch, remove it and form a new string and remove them.
Again check and remove them.
Optimal approach: stack can be used to. Once one combination of char is gone, the next ch needs to be combined with the
previous. This is the main intuition behind using stack. In the stack we store the ch with its frequency.

It checks too soon whether the top of the stack reached k before adding the new character’s count.
It is possible that, after removing a group of k characters, the newly exposed neighbors might form another group of k.
TC: O(n) to traverse string + O(n) traverse stack
Todo: via array
"""


class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        stack = []

        for curr_ch in s:

            # if ch at top of stack is equal to current ch
            if stack and curr_ch == stack[-1][0]:
                # increase frequency
                stack[-1][1] += 1
                # check if freq = k is reached
                # should be checked after the top of stack is updated
                if stack[-1][1] == k:
                    stack.pop()
            else:
                stack.append([curr_ch, 1])
        ans = []
        while stack:
            ch, freq = stack.pop()
            temp = [ch for _ in range(freq)]
            ans += temp
        ans.reverse()
        return "".join(ans)

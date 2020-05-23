'''
Time Complexity: O(n) -> no of elements in set
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation:
Use 2 pointers start and end. If we see a 0, increment number of flips (0's to 1's). Once flips is >k
we move the start pointer until we see a 0 so that we can get atleast 1 flip to reuse further in the iteration.
At each step keep calculating the maxLength and return the min of them.
'''

class Solution:
    def longestOnes(self, A: List[int], k: int) -> int:
        # Solution 2 - easier
        flips = 0
        start = 0
        end = 0
        maxLen = 0

        while end < len(A):
            if A[end] == 0:
                flips += 1

            # violated move the start to the next 0 until we have atleast 1 flip remaining so we can continue with checking
            while start <= end and flips > k:
                if A[start] == 0:
                    flips -= 1
                start += 1
            maxLen = max(maxLen, end - start + 1)
            end += 1

        return maxLen

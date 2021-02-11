"""
Time Complexity : O(n) 
Space Complexity : O(1)  
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

This is a sliding window problem. Here everytime we encounter a 0, we kind of consume it and decrement K's value. But if K becomes 
negative, ie, we are trying to consume more 0's than recommended, we move our left pointer . If the outgoping character is also a 0, we
increment K. 
"""


class Solution:
    def longestOnes(self, A: List[int], K: int) -> int:
        left = 0
        l = len(A)
        for i in range(l):
            if A[i] == 0:
                K -= 1
            if K < 0:
                if A[left] == 0:
                    K += 1
                left += 1
        return l-left

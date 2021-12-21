"""
https://leetcode.com/problems/max-consecutive-ones/
"""

class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        """tc- on sc-o1"""
        currlength = 0
        maxlength = 0
        for i in range(len(nums)):
            if nums[i] == 1:
                currlength += 1
            else:
                ##find the maximumcontiguous one's til now
                maxlength = max(maxlength, currlength)
                currlength = 0

        maxlength = max(maxlength, currlength)
        return maxlength


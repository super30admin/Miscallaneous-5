"""
https://leetcode.com/problems/max-consecutive-ones-iii/
"""


class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        """
        TC on
        sc on
        """
        left = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                k -= 1
                ##now we can accomodate one less 0
            if k < 0:
                ##more 0s than required so move the left pointer
                if nums[left] == 0:
                    k += 1
                left += 1

        return len(nums) - left



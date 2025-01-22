"""
Brute force: find all the possible subarray with atmost k number of 0.
TC: O(n^2)

Optimal approach: sliding window and 2 pointers
slow and fast pointers defines the window. slow pointer moves when the number of zeroes in the window exceeds the
max number of allowed zero, and it keeps moving until it escapes one 0.
TC: O(2n) SC: O(1)

We can make it one pass as well:
once the max window size is found, keep the size fixed.
when number of zeroes is higher than allowed to move the slow pointer by 1. Once a window is found, the idea is to keep
it growing instead of shrinking or else this size will be maintained till last.
Todo: brute force and one pass
"""


class Solution:
    def two_pass_longestOnes(self, nums: List[int], k: int) -> int:

        slow = 0
        fast = 0
        ans = 0
        # [0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1]
        #        s
        #                             f
        # k = 0
        while fast < len(nums):
            # check the number of zero
            # if more than allowed
            if k < 0:
                while slow < len(nums) and nums[slow] != 0:
                    slow += 1
                # when this loop end, 0 is not escaped so increment slow by 1
                # and update k
                slow += 1
                k += 1

            # when numbe of zero are less than allowed
            elif k >= 0:
                if nums[fast] == 0:
                    k -= 1
                fast += 1

            # if the k >= 0 then only update the answer
            if k >= 0:
                ans = max(ans, fast - slow)

        return ans

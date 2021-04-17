# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Sliding Window Approach


class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        if not nums:
            return None

        i = 0
        maxlength = 0
        for j in range(len(nums)):
            if nums[j] == 0:
                k -= 1
            if k < 0:
                if nums[i] == 0:
                    k += 1
                i += 1
            else:
                maxlength = max(maxlength, j - i + 1)
        return maxlength

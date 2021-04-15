# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        if not nums:
            return 0
        
        left = 0
        
        for i in range(len(nums)):
            if nums[i] == 0:
                k -= 1
            
            if k < 0:
                if nums[left] == 0:
                    k += 1
                left += 1
        return len(nums) - left
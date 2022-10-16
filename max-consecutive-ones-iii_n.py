# Time Complexity : O(N) where N is total numbers in the list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        slow = 0
        
        for fast in range(len(nums)):
            if nums[fast] == 0:
                k -= 1
                
            if k < 0:
                if nums[slow] == 0:
                    k += 1
                slow += 1
            
        return fast - slow + 1
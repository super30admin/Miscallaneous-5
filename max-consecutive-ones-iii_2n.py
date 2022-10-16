# Time Complexity : O(2 N) where N is total numbers in the list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        slow, fast = 0, 0
        maxCon = 0
        
        n = len(nums)
        
        while fast < n:
            if nums[fast] == 0:
                k -= 1
                
            if k < 0:
                while nums[slow] != 0:
                    slow += 1
                slow += 1
                k = 0
                
            maxCon = max(maxCon, fast - slow + 1)
           
            fast += 1
                
        return maxCon
# Time complexity : O(2*n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        # declare a slow pointer which acts as the left pointer and a max_val to store the max
        slow = 0
        max_val = 0
        n = len(nums)
        
        # traverse over the array
        for i in range(n):
          
            # if we encounter a 0, then decrement k
            if nums[i] == 0:
                k -= 1
            
            # if value becomes less than 0, then increment the slow pointer such that we do not encounter a 0
            if k < 0:
                while slow <= i and nums[slow] == 1:
                    slow += 1
                # increment the 0 and also value of k by 1
                slow += 1
                k += 1
            
            # find the max val
            max_val = max(max_val, i - slow + 1)
        
        # return the max Value
        return max_val

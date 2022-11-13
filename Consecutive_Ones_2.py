# Time complexity : O(n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        # declare slow and max_val pointer
        slow = 0
        max_val = 0
        n = len(nums)
        
        # traverse over the array
        for i in range(n):
          
            # if the i th index is 0, then decrement the value of k
            if nums[i] == 0:
                k -= 1
            
            # if value of k is less than 0
            if k < 0:
               # check if the value at slow pointer is 0, if so then increment the k and then slow pointer
                if nums[slow] == 0:
                    k += 1
                slow += 1
            
            # find the max length
            max_val = max(max_val, i - slow + 1)
        
        return max_val

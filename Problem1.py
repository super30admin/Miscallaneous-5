#Time Complexity: O(N)
#Space Complexity: O(1)
class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        left = 0
        for i in nums:
            if i == 0:
                k -=1
            if k < 0:
                if nums[left] == 0:
                    k+=1
                left +=1
                
        return len(nums) - left
                
            
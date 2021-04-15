#time: O(n)
#space: O(1)
class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        left = 0
        length = 0
        count = 0
        
        for right in range(len(nums)):
            if nums[right] == 1:
                count += 1
            
            while right-left+1 - count > k:
                if nums[left] == 1:
                    count -= 1
                left +=1
        
            length = max(length, right-left+1)
        
        return length
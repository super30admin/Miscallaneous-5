# Approach - Brute Force (O(N^2)) optimise it with sliding window
# Any time num of zeros > K, slide window from start and if it is 0 charc, decrement the count as it is an outgoing charac
# Either way, update max len and increment pointer on end

# Time - O(N)
# Space - O(1)

class Solution:
    def longestOnes(self, nums: List[int], K: int) -> int:
        
        if not nums:
            return 0
        
        start = 0
        end = 0
        max_len = 0
        num_of_zeros = 0
        
        while end < len(nums):
            
            if nums[end] == 0:
                num_of_zeros += 1
                
            while num_of_zeros > K:
                if nums[start] == 0: # outgoing char
                    num_of_zeros -= 1
                    
                start += 1
                
            max_len = max(max_len, end - start + 1)
            end += 1 # increase window by sliding
            
        return max_len
                    
                
        
        
        
        
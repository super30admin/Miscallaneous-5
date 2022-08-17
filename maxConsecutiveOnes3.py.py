'''
Time Complexity: 0(n) -- Asymptotically
Space Complexity: 0(1) 
Run on LeetCode: Yes
'''
class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        
        # maintain slow ptr and fast ptr
        slow = 0
        fast = 0
        
        # maintain a maxCount 
        maxCount = 0
        
        # iterate the nums list
        while fast != len(nums):
            
            if nums[fast] == 1:
                fast += 1
                
            elif nums[fast] == 0 and k != 0:
                fast += 1
                # update k value
                k -= 1
                
            elif nums[fast] == 0 and k == 0:
                flag = True
                
                # loop to move slow
                while flag == True:
                    if nums[slow] == 1:
                        slow += 1
                    
                    elif nums[slow] == 0:
                        k += 1
                        slow += 1
                        flag = False                    
                '''end of inner while loop'''
                
            # update the maxCount
            maxCount = max(maxCount,(fast-slow))
        '''end of while loop'''
        
        # return maxCount
        # print('maxCount is:\t',maxCount)
        return maxCount
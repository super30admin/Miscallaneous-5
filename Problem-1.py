class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        left,right=0,0
        while left<=right<=len(nums)-1:
            if nums[right]==0:
                k-=1
            if k<0:
                if nums[left]==0:
                    k+=1
                left+=1
                
            right+=1
            
        return len(nums)-left
            
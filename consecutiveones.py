class Solution:
    # take slow and fast pointers, fast moves by one, when k <0 , move slow by one and keep the window length constant
    #TC-O(n),SC-O(1)
    def longestOnes(self, nums: List[int], k: int) -> int:
        slow=0
        n=len(nums)
        maxi=0
        for i in range(n):
            if nums[i]==0:
                k-=1
            if k<0:
                if nums[slow]==0:
                    k+=1
                slow+=1
            if k>=0:
                maxi = max(i-slow+1,maxi)
        return maxi
            


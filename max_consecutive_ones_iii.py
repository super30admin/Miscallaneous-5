class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        ## T.C = O(n)
        ## S.C = O(1)

        n = len(nums)
        l, r = 0, 0
        p = k

        while r < n:
            if nums[r] == 0:
                p -= 1
            if p < 0:
                if nums[l] == 0:
                    p += 1
                l += 1
            r += 1
                    
        mx = r - l
        return mx       
#Approach
#maintain 2 ppinters slow and j and move the window untill no of zeros are less than k if equal to k count the size of window and son


#Complexities
#Time: O(N)
#Space: O(1)


from typing import List


# class Solution:
#     def longestOnes(self, nums: List[int], k: int) -> int:
#         left, right, zeros, result = 0, 0, 0, 0
#         while (right < len(nums)):
#             if nums[right] == 0:
#                 zeros += 1
#             if zeros > k:
#                 if nums[left] == 0:
#                     zeros -= 1
#                 left += 1
#             else:
#                 result = max(result, right - left + 1)
#             right += 1
#         return result


# class Solution:
#     def longestOnes(self, nums: List[int], k: int) -> int:
#         slow = 0
#         res = 0
#
#         for i in range(len(nums)):
#             if nums[i] == 0:
#                 k -= 1
#                 if k < 0:
#                     while k<0:
#                         if nums[slow] == 0:
#                             k += 1
#                             break
#                         slow+=1
#                     slow += 1
#
#             res = max(res, i - slow + 1)
#
#         return res

class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        slow = 0

        for i in range(len(nums)):
            if nums[i] == 0:
                k -= 1
            if k < 0:
                if nums[slow]==0:
                    k+=1
                slow += 1



        return len(nums)-slow
s = Solution()
s.longestOnes([1,1,1,0,0,0,1,1,1,1,0],2)
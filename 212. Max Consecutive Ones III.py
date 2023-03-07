class Solution:
    def longestOnes(self, nums, k):
        left = 0

        for num in nums:
            if num == 0:
                k -= 1
            if k < 0:
                if nums[left] == 0:
                    k += 1
                left += 1

        return len(nums) - left


# Sliding Window
# Time Complexity : O(n)
# Space Complexity: O(1)

nums = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]
k = 2
if __name__ == "__main__":
    obj = Solution()
    print(obj.longestOnes(nums, k))

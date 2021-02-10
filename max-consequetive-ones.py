# TIME COMPLEXITY: O(N)
# SPACE COMPLEXITY: O(1)

class Solution(object):
    def longestOnes(self, A, K):
        """
        :type A: List[int]
        :type K: int
        :rtype: int
        """
        # Use a sliding window to keep track of the longest cintguous subarray
        start = 0
        end = 0
        count_ones = 0
        max_len = 0
        for end in range(len(A)):
            # Keep track of the maximum number of ones in the window
            if A[end] == 1:
                count_ones += 1
            # If the number of 0's in the window are more than K, shrink the window
            while end - start + 1 - count_ones > K:
                start_char = A[start]
                if start_char == 1:
                    count_ones -= 1
                start += 1
            # Keep track of the max window size so far
            # Only windows that satisfy the condition of 0's <= K reach here...
            max_len = max(max_len, end - start + 1)
        return max_len
                    
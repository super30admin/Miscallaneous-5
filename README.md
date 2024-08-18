# Misc-5

## Problem 1: Find Consecutive Ones(https://leetcode.com/problems/max-consecutive-ones-iii/)

# sliding window problem
# left, right & length = right - left + 1 
# maintain max_len
# one pass if num_zero > k then recalculate left
# O(N) time, O(1) space

class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        left = 0
        num_zero = 0
        max_len = 0

        for right in range(len(nums)):

            if nums[right] == 0:
                num_zero += 1

            while(num_zero > k):
                if(nums[left] == 0):
                    num_zero -= 1
                left += 1
            
            max_len= max(max_len, right - left + 1)  

        return max_len  

## Problems 2 : Remove all the continuous character

Given a string we have to remove all the continuous character whose count is more than 2.
For example :
1. abba ----> abba
2. abbb---->a is the output because c count is 3.
3. abbbaa---> '' empty string
4. abbacccaa--->abbHere relative order of characters and their counts must be maintained so we figured out that we cannot use hashtable.
Give a solution better than O(n^2).

def remove_consecutive_characters(s: str) -> str:
    stack = []
    
    for char in s:
        if stack and stack[-1][0] == char:
            # Increment the count of the character at the top of the stack
            stack[-1][1] += 1
        else:
            # Push the new character onto the stack with a count of 1
            stack.append([char, 1])
        
        # If the count of the character is greater than 2, remove it
        if stack[-1][1] > 2:
            stack.pop()
    
    # Rebuild the string from the stack
    result = ''.join(char * count for char, count in stack)
    
    return result


 


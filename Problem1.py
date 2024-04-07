'''
1. We keep two pointers i and j. j is for traversing the entire array and i is to point to the beginning of the subarray that has maximum 1s
2. Everytime we get a 0 element we decrease the value of k like we flipped to 1. 
3. If the value k goes negative we move the start pointer of subarray to the next element of the first encountered 0 in subarray. We remove such leading zeros until k value is negative. Length is j-i+1

TC: O(n)
SC: O(1)
'''


from typing import List
def longestOnes(nums: List[int], k: int) -> int:
    
    maxcount  = 0
    i = 0
    j = 0
    for j in range(len(nums)):
        if nums[j] == 0:
            k -= 1
            while k < 0:
                if nums[i] == 0:
                    k+=1
                i+=1
        maxcount = max(j-i+1,maxcount)

    return maxcount



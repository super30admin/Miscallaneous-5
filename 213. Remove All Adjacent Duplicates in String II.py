class Solution:
    def removeDuplicates(self,s, k):
        if s is None or len(s) <= 1:
            return s
        result = list()
        # stack to store char and count of char in a list
        st = list()

        for i in range(len(s)):
            # check if stack is not empty and the top element of the stack is equal to current i'th element
            # if yes we increase the count the char
            if st and st[-1][0] == s[i]:
                st[-1][1] += 1
            # else append the char with count as 1
            else:
                st.append([s[i], 1])
            # if the count of the top element becomes equal to k we pop the top element
            if st[-1][1] == k:
                st.pop()
        # in the end we append the remaining elements in the list
        # return the list into string
        for s in st:
            result.append(s[0] * s[1])

        return "".join(result)


# Stack
# Time Complexity: O(n) we iterate through the entire string
# Space Complexity:O(n). Size of the stack

s = "deeedbbcccbdaa"
k = 3
if __name__ == "__main__":
    obj = Solution()
    print(obj.removeDuplicates(s, k))

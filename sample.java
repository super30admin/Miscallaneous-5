// Max Consecutive Ones III
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int longestOnes(int[] A, int K) {
        int max = 0;
        int start = 0; int end = 0;
        // while condition
        while (end < A.length) {
            // if current is 0, then decrement K count
            if (A[end++] == 0) {
                K--;
            }
            // while condition for K less than 0
            while (K < 0) {
                // if leaving point equals 0, then increment K count
                if (A[start++] == 0) {
                    K++;
                }
            }
            // get max length
            max = Math.max(max, end - start);
        }
        
        return max;
    }
}

// remove all the continuous character
// Time Complexity: O(n * k) where n = length of string and k = given count to remove duplicates
// Space Complexity: O(n) for stringbuilder

class Solution {
    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();
        // loop over string
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            // append character to string builder
            sb.append(c);
            // if peek character equals current character
            if (!stack.isEmpty() && c == (char)stack.peek()[0]) {
                // increment the count in stack
                stack.peek()[1] += 1;
                // if peek count equals k, then delete character from string builder
                if (stack.peek()[1] == k) {
                    for (int j=0; j<k; j++) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    stack.pop();
                }
            } else { // if peek not equal to curr, then push the curr to top of stack with count 1
                stack.push(new int[]{c, 1});
            }
        }
        // return the result string
        return sb.toString();
    }
}

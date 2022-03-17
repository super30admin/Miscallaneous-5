// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
// We have solved this for a generic case k, this will work for continuous character whose count is more than 2
class Solution {
    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() == 0) return "";

        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for (int i=0; i<sb.length(); i++) {
            if (st.isEmpty() || sb.charAt(i) != sb.charAt(i-1)) {
                st.push(1);
            }
            else {
                // pop the value from stack and check if its equal to k, in that case we can delete the k elements from sb
                // otherwise we can add 1 to the value on top of the stack
                int cnt = st.pop();
                if (cnt+1 == k) {
                    sb.delete(i-k+1, i+1);
                    // place i at the correct position
                    i = i-k;
                }
                else {
                    st.push(cnt+1);
                }
            }
        }

        return sb.toString();
    }
}


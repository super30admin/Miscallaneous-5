// Problem 1209. Remove All Adjacent Duplicates in String II
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> st = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (st.isEmpty() || st.peek() != c) {
                st.push(c);
                numSt.push(1);
            } else {
                int cnt = numSt.pop();
                cnt++;
                if (cnt == k) {
                    st.pop();
                } else {
                    numSt.push(cnt);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            char ch = st.pop();
            int cnt = numSt.pop();
            for (int i = 0; i < cnt; i++) {
                sb.append(ch);
            }
        }
        return sb.reverse().toString();
    }
}
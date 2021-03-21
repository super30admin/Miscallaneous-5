// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public String removeDuplicates(String s, int k) {
        
        if(s == null || s.length() == 0) return s;
        
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < sb.length(); i++) {
            
            if(i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                st.push(1);
            }
            else 
            {
                int prevCount = st.pop();
                if(prevCount + 1 == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                }
                else
                {
                    st.push(prevCount + 1);
                }
            }
        }
        return sb.toString();
    }
}
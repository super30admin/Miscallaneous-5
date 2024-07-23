// Time Complexity : O(2N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach - Using stack to track the character and its frequency.
// When ever the frequency equals to k, pop the element and cont from stack

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> st = new Stack<>();
        Stack<Integer> cntSt = new Stack<>();

        for(int i=0;i< s.length();i++){
            char c = s.charAt(i);

            if(!st.isEmpty() && st.peek() == c){
                int cnt = cntSt.pop();
                cnt++;

                if(cnt == k){
                    st.pop();
                }else {
                    cntSt.push(cnt);
                }
            }else{
                st.push(c);
                cntSt.push(1);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()) {
            int cnt = cntSt.pop();
            char c = st.pop();

            for(int i=0;i< cnt;i++){
                sb.append(c);
            }
        }

        return sb.reverse().toString();
    }
}
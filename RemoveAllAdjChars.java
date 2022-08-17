// Time: O(N) | Space: O(2N)

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> st = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(!st.isEmpty() && st.peek() == c) {
                int count = numSt.pop()+1;
                if(count == k) {
                    st.pop();
                } else
                    numSt.push(count);
            } else {
                st.push(c);
                numSt.push(1);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            char curr = st.pop();
            int times = numSt.pop();
            for(int i=0;i<times;i++) {
                sb.append(curr);
            }
        }
        return sb.reverse().toString();
    }

}
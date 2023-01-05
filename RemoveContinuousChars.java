// Tc - O(n^2)
// Sc - O(n)
class Solution {
    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() == 0) return s;

        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<sb.length(); i++) {
            if(st.isEmpty() || sb.charAt(i) != sb.charAt(i-1)) {
                st.push(1);
            } else {
                int count = st.pop();
                count++;
                if (count == k) {
                    sb.delete(i-k+1, i+1);
                    i = i-k;
                } else {
                    st.push(count);
                }
            }
        }

        return sb.toString();
    }
}
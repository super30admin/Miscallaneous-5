// Time Complexity : O(n^2) // for stringbuilder concatinating
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String removeDuplicates(String s, int k) {
        if(s==null || s.length()==0){
            return s;
        }
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for(int i =0; i<sb.length(); i++){
            if(st.isEmpty() || sb.charAt(i) != sb.charAt(i-1) ){
                st.push(1);
            }
            else{
                int cnt = st.pop();
                if(cnt+1 == k){
                    sb.delete(i-k+1 ,i+1);
                    i = i-k;
                }else{
                    st.push(cnt+1);
                }
            }
        }
        return sb.toString();
    }
}
// Time Complexity : O(N) where N is the length of String
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Use stack to store the character's count
// When the count becomes k then remove, and reset pointers
// Finally return the string left
class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < sb.length(); i++){
            if(i == 0 || sb.charAt(i) != sb.charAt(i-1)){
                st.push(1);
            }
            else{
                int top = st.pop();
                top++;
                if(top == k){
                    sb.delete(i-k+1, i+1);
                    i = i-k;
                }
                else{
                    st.push(top);
                }
            }
        }
        return sb.toString();
    }
}
import java.util.Stack;

//Time complexity: O(n)
//Space complexity; O(n)
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> st=new Stack<>();
        Stack<Integer> numSt=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(!st.isEmpty() && c==st.peek()){
                int count=numSt.pop();
                if(count+1==k){
                    st.pop();
                }
                else{
                    numSt.push(count+1);
                }
            }
            else{
                st.push(c);
                numSt.push(1);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty())
        {
            char c=st.pop();
            int count=numSt.pop();
            for(int i=0;i<count;i++)
                sb.append(c);
        }
        return sb.reverse().toString();
        
    }
}
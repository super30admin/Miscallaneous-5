//TC:O(n)
//SC:O(n)
public class Solution{

    public String removeDuplicates(String s)
    {
        Stack<Character> st = new Stack<>();

        for(char c: s.toCharArray())
        {
            if(!st.isEmpty() || c != st.peek())
            {
                st.push(c);
            }     
            else
            {
                char top = st.pop();
                if(!st.isEmpty() && c == st.peek())
                {
                    while(!st.isEMpty() && st.peek() == top)
                    {
                        st.pop();
                    }
                }
                else
                {
                    st.push(top);
                    st.push(c);

                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
    
}
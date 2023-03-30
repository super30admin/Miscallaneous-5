public class RemoveAllContinuousCharacter {
    public String removeDuplicates(String s, int k) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<sb.length();i++){
            if(i==0 || sb.charAt(i)!=sb.charAt(i-1)){
                st.push(1);
            }else{
                int sum = st.pop()+1;
                if(sum==k){
                    sb.delete(i-sum+1,i+1);
                    i=i-k;
                }else{
                    st.push(sum);
                }
            }
        }
        return sb.toString();
    }
}

// TC - O(n)
// SC - O(n)
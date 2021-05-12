//time complexity-O(n)
//Space complexity-O(n)
//Ran on leetcode-Yes
//Solution with comments-
import java.util.Stack;
class RemoveCaharacters{
    public String Remove(String s){
        Stack<Pair<Character,Integer>> st = new Stack<>();
        Pair<Character, Integer> temp;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!st.isEmpty()){
                Pair<Character, Integer> tp= st.peek();
                if(tp==ch){
                    temp=st.pop();
                    st.push(new Pair<>(ch,temp.getValue()+1));//adding same charcter and increasing the couunt
                }
                else{
                    if(st.peek().getValue()>2)//if the length of top element in Stack>2 we remove it
                        st.pop();
                    temp=new Pair<ch,1>
                    st.push(temp);
                }
            }
            else{
                temp=new Pair<ch,1>
                st.push(temp);
            }
        }
        String res="";
        while(!st.isEmpty()){
            temp=st.pop();
            int v= temp.getValue();
            while(v>0){
                res+=temp.getKey();
                v--;
            }
        }
        return res;
    }
    public static void main(String args[]){
        RemoveCaharacters obj= new RemoveCaharacters();
        System.out.println(obj.Remove("aabb"));
    }
}
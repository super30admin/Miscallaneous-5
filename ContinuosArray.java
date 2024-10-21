// "static void main" must be defined in a public class.
/*
Given a string we have to remove all the continuous character whose count is more than 2. For example :

abba ----> abba
abbb---->a is the output because c count is 3.
abbbaa---> '' empty string
abbacccaa--->abbHere relative order of characters and their counts must be maintained so we figured out that we cannot use hashtable. Give a solution better than O(n^2).
*/
public class ContinuosArray {
    public static void main(String[] args) {
        System.out.println("Output expected --> b "+ "output "+RemoveContinous("bbaaabb"));
        System.out.println("Output expected --> a "+ "output "+RemoveContinous("abbb"));
        System.out.println("Output expected -->  "+ "output "+RemoveContinous("abbbaa"));
        System.out.println("Output expected --> abb "+ "output "+RemoveContinous("abbacccaa"));
        
    }
    private static String RemoveContinous(String s){
        Stack<int[]> st = new Stack<>();
        if(s.length()==0){
            return "";
        }
        char ch = s.charAt(0);
        st.push(new int[]{ch-'0',1});
        int i=1;
        int val;
        while(i<s.length()){
            
            
            ch = s.charAt(i);
            val = ch-'0';
            if(st.isEmpty()){
                st.push(new int[]{val,1});
                i++;
                continue;
            }
            int[] node = st.peek();
            
            if(node[0]==val){
                node[1]++;
                if(node[1]==3){
                    st.pop();
                }
                
            }
            else{
                st.push(new int[]{val,1});
            }
            i++;
        }//while
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            int[] node = st.pop();
            char c=(char)(node[0]+'0');
            int count = node[1];
            while(count>0){
              res.insert(0,c);
                count--;
            }
            
        }
        
        return res.toString();
        
        
    }//method
}
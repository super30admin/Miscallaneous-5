import java.util.Stack;

// Time Complexity : Add : O(N . log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class RemoveAllAdjacentDuplicatesinStringII {
    public static void main(String[] args) {
        String s = "abcd";
        int k = 2;
        removeDuplicates(s, k);
    }

    public static String removeDuplicates(String s, int k) {
        Stack<Character> stk = new Stack<>();
        Stack<Integer> nStk = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!stk.isEmpty() && stk.peek()==ch){
                if(nStk.peek()+1 == k){
                    stk.pop();
                    nStk.pop();
                } else {
                    nStk.push(nStk.pop()+1);
                }
            } else{
                stk.push(ch);
                nStk.push(1);
            }
        }

        while(!stk.isEmpty()){
            char c = stk.pop();
            int count = nStk.pop();
            for(int i=0; i<count; i++){
                sb.append(c);
            }
        }

        return sb.reverse().toString();
    }

}


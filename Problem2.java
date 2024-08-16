package Misc-5;
// TC: O(N)
// SC: O(N)
public class Problem2 {
    public String removeDuplicates(String s, int k) {
        Stack<Character> chStack = new Stack<>();
        Stack<Integer> cntStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!chStack.isEmpty() && chStack.peek() == ch){
                int cnt = cntStack.pop();
                cnt++;
                if(cnt == k){
                    chStack.pop();
                }else{
                    cntStack.push(cnt);
                }
            }else{
                chStack.push(ch);
                cntStack.push(1);
            }
        }

        while(!chStack.isEmpty()){
            int localCnt = cntStack.pop();
            char ch = chStack.pop();
            for(int i=0;i<localCnt;i++){
                sb.append(ch);
            }
        }

        return sb.reverse().toString();
    }
}

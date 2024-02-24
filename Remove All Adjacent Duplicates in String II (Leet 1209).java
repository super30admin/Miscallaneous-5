/*
Time: O(n)
Space: O(n)
Executed Sucessfully: Yes
*/


class Solution {
    public String removeDuplicates(String s, int k) {
        Stack <Character> cst = new Stack<>();
        Stack <Integer> ist = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(cst.isEmpty() || cst.peek() != c){
                cst.push(c);
                ist.push(1);
            }else if (cst.peek() == c){
                int co = ist.pop();
                co++;
                if (k != co){
                    ist.push(co);
                }else{
                    cst.pop();
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!cst.isEmpty()){
            int count = ist.pop();
            char cha = cst.pop();
            for(int i = 0; i < count; i++){
                sb.append(cha);
            }
        }
        
        return sb.reverse().toString();
        
    }
}

import java.util.Stack;

// Time Complexity : O(2n) -> O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

public class RemoveAllContinuousCharacters {

        public String removeDuplicates(String s) {
            Stack<Character> charSt = new Stack<>();
            Stack<Integer> numSt = new Stack<>();
            int k=2;
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);

                if(!charSt.isEmpty() && charSt.peek() == c){
                    numSt.push(numSt.pop()+1);

                    if(numSt.peek() == k){
                        numSt.pop();
                        charSt.pop();
                    }
                }else{
                    charSt.push(c);
                    numSt.push(1);
                }
            }

            StringBuilder result = new StringBuilder();

            while(!numSt.isEmpty()){
                int num = numSt.pop();
                char c = charSt.pop();

                for(int j=0; j<num; j++){
                    result.append(c);
                }
            }

            return result.reverse().toString();
        }
    }
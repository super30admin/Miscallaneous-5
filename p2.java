// Time Complexity :O(n) where n is the length of the string
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public String removeDuplicates(String s, int k) {
        //to keep track of previous characters
        Stack<Character> c = new Stack<>();
        //to keep track of previos character's frequency
        Stack<Integer> in = new Stack<>();
        StringBuilder sb = new StringBuilder();
        //go through all the characters to remove the k repaeting characters
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!c.isEmpty() && c.peek() == ch){
                if(in.peek()+1 == k){
                    c.pop();
                    in.pop();
                }else{
                    in.push(in.pop()+1);
                }
            }else{
                c.push(ch);
                in.push(1);
            }
        }
        //get the result from stack
        int size = c.size();
        for(int i=0; i<size; i++){
            for(int j=0; j<in.peek(); j++){
                sb.append(c.peek());
            }
            c.pop();
            in.pop();
        }
        //reverse the result
        return sb.reverse().toString();
    }
}
/*
We are given a striong s and an integer k

we need to remove k consecutive elements , and after the remove the left chars joins with right chars, and after joining , if the characters are k , we again remove them
we will keep on doing it until we canoot do it anymore. return the resulting string after doing this opearion multiple times.

Think of it as tetris game, where when a matching block forms a square it dis appear and all the blocks fall down to match with the rest of them and this process re peat

Intuition:
We will use a character stack and an integer stack. 
Whenever we encounter a characters, we will check if that character already exists on the top of the stack , if so we will pop out the current count from the integer stack and increment by one and push it back

whenever we encounter a character which is not macthing with the top of the stack, we will add the character to the character stack and then push 1 into the integer stack

we will keep checking if the top of the integer stack is equal to the k , if so we will remove from integer and character stack

at the end, we will form a string from the characters left in the stack and (reverse them) and return interface

Time : O(n + 2k) where k is the number of characters left after removals

Space : O ( 2n) // for stacks

*/

class Solution {
    public String removeDuplicates(String s, int k) {
        
        Stack<Character> charStack = new Stack<Character>();
        Stack<Integer> intStack = new Stack<Integer>();

        for(int i=0;i<s.length();i++){
            char current = s.charAt(i);
            // check if the current char equals to the char on the Stack
            if(!charStack.isEmpty() && charStack.peek() == current){
                // get the number and increment to it
                int num = intStack.pop();
                intStack.push(num+1);
            }else{
                charStack.push(current);
                intStack.push(1);
            }

            // check if count of any stack is k 
            if(!intStack.isEmpty() && intStack.peek() == k){
                // remove the elements
                intStack.pop();
                charStack.pop();
            }
        }

        // form a string with the characters left in the stack
        StringBuilder result = new StringBuilder();
        while(!charStack.isEmpty()){
            int num = intStack.pop();
            char c = charStack.pop();

            int j=0;
            while(j<num){
                result.append(c);
                j++;
            }
        }

        return result.reverse().toString();
    }
}
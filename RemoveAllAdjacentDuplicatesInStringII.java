class Solution {

    //Time Complexity: 0(n) where n is the no. of characer in string
    //Space Complexity: 0(n)

    public String removeDuplicates(String s, int k) {
        if(s == null || s.length() == 0 || k == 0){
            return s;
        }

        Stack<Integer> st = new Stack<>(); //Stack to keep a count of duplicates
        Stack<Character> c = new Stack<>(); //stack to keep a track of non dupicate characters
        StringBuilder sb = new StringBuilder(); //to get the final output

        st.push(1); //pushing 1 as count of 1st characeter will be 1
        c.push(s.charAt(0));    //pushing the 1st character

        for(int i = 1; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!c.isEmpty() && ch == c.peek()){ //if my stack is not empty and the previous character inserted in the stack is same to current character
                int count = st.pop();   //i pop the previous count of that character
                st.push(count + 1); //and increase it's count and push it back to the stack
            }
            else{
                st.push(1); //else I push the current new character along with a count of 1
                c.push(ch);
            }
            if(st.peek() == k){ //if my count is equal to k that means I need to remove the stram of characters
                st.pop();
                c.pop();
            }
        }

        while(!c.isEmpty()){    //For the output, I need to add all the remaining character to my stringbuilder
            int count = st.pop();   //I need to iterate over the no. of time the character exists
            char character = c.pop();   //I pop the character
            for(int i = 0; i < count; i++){ //add the character as many times it exists
                sb.append(character);
            }
        }

        return sb.reverse().toString(); //I reverse because in my stringbuilder for abcd, the output will be dcba as a will be popped at the end from stack. So I need to reverse the string
    }
}

//Another Method

class Solution {

    //Time Complexity : 0(n^2). Here deleting from stringbuilder is causing extra time and n is the no. of characters in my string
    //Space Complexity: 0 (n)

    public String removeDuplicates(String s, int k) {
        if(s == null || s.length() == 0 || k == 0){
            return s;
        }

        StringBuilder sb = new StringBuilder(s);    //Initially storing the string in my stringbuilder
        Stack<Integer> st = new Stack<>();  //to keep a track of no of times the character has been seen continuously

        for(int i = 0; i < sb.length(); i++){   //Going to the length of stringbuilder which keeps on changing
            if(st.isEmpty() || sb.charAt(i) != sb.charAt(i - 1)){   //is stack is empty of the current character does not match the previous character
                st.push(1); //I push 1 to my stack
            }
            else{
                int count = st.pop();   //Else if characters are same, I pop the top of the stack
                if(count + 1 == k){ //check if it is equal to k or not
                    sb.delete(i - k + 1, i + 1);    //if it is, then I delete those stream of characters from my stringbuilder
                    i = i - k;  //also have to reset i as the position of characters in stringbuilder must have changed after deletion
                }
                else{
                    st.push(count + 1); //if not, then I just add 1 to count and push it back in
                }
            }
        }

        return sb.toString();   //at the end, I return the remaining string
    }
}

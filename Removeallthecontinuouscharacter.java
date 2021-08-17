import java.util.*;

public class Removeallthecontinuouscharacter {

    public class CustomPair {
        Character c;
        int count;

        public CustomPair(Character c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    // As the current element can be calculated based on the upcoming element we can use Stack.
    // If the top element is equal to the new element increment the count.
    // else check if the top element cound is greater than 3 then remove top element and push new element
    // At end we will have the valid string, iterate reverse and form the result.
    //TC: O(N) Where N is length of the given string.
    //SC: O(N) Where N is length of the given string.
    public String removeContineousCharacters(String str) {
        if (str == null || str.length() == 0)
            return str;
        Stack<CustomPair> stack = new Stack();
        stack.push(new CustomPair(str.charAt(0), 1));
        for (int i = 1; i < str.length(); i++) {
            char incomingCharacter = str.charAt(i);
            if(stack.isEmpty()) {
                stack.push(new CustomPair(incomingCharacter, 1));
            } else {
                if (stack.peek().c == incomingCharacter) {
                    CustomPair current = stack.peek();
                    current.count += 1;
                    stack.pop();
                    stack.push(current);
                } else {
                    if (stack.peek().count >= 3) {
                        stack.pop();
                    }
                    stack.push(new CustomPair(incomingCharacter, 1));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop().c);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Removeallthecontinuouscharacter re = new Removeallthecontinuouscharacter();
        String result = re.removeContineousCharacters("abbacccaa");
        System.out.println("The result: " + result);
    }
}

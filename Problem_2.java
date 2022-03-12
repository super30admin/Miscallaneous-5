// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.io.*;
import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        String s = "aabbba";
        Stack<Character> ch = new Stack<>();
        Stack<Integer> in = new Stack<>();
        for(char c : s.toCharArray()){
            if(!ch.isEmpty() && ch.peek() == c){
                int val = in.peek();
                in.pop();
                val++;
                in.push(val);
            }else{
                in.push(1);
                ch.push(c);
            }
            if(in.peek() >= 3){
                in.pop();
                ch.pop();
            }
        }
       // System.out.println("Ans :"+ch.toString());
        StringBuilder st = new StringBuilder();
        while(!ch.isEmpty()){
            st.append(ch.pop());
            in.pop();
        }
        System.out.println("Ans :"+st.toString());
    }
}

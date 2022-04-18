package misc5;

import java.util.Stack;

public class RemoveAllTheContinuousCharacter {
	public static void main(String[] args) {
		String str = "abbacccaa";
		RemoveAllTheContinuousCharacter ratcc = new RemoveAllTheContinuousCharacter();
		System.out.println(ratcc.removeChars(str));
	    // abba -> abba
	    // abbb -> a
	    // abbbaa -> ""
	    // abbacccaa -> abb
	}
	
	public String removeChars(String str) {
		// null
		if(str == null || str.length() == 0)
			return str;
		
		Stack<Character> st1 = new Stack<>();
		Stack<Integer> st2 = new Stack<>();
		
		int i = 0;
		while(i < str.length()) {
			char c = str.charAt(i);
			if(!st1.isEmpty() && st1.peek() == c) {
				int currCount = st2.pop();
				currCount++;
				if(currCount == 3)
					st1.pop();
				else 
					st2.push(currCount);
			} else {
				st1.push(c);
				st2.push(1);
			}
			i++;
		}
		
		StringBuilder sb = new StringBuilder();
		while(!st1.isEmpty()) {
			char c = st1.pop();
			int count = st2.pop();
			for(int j=0; j<count; j++)
				sb.append(c);
		}
		
		return sb.reverse().toString();
	}
}

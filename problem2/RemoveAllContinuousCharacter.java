// Time Complexity : O(n), n -> Length of string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

package problem2;

import java.util.Stack;

public class RemoveAllContinuousCharacter {
	private String removeContiguousCharacters(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}

		StringBuilder sb = new StringBuilder();

		Stack<Pair> stack = new Stack<>();
		int n = str.length();
		stack.push(new Pair(str.charAt(0), 1));

		for (int i = 1; i < n; i++) {
			Pair p = stack.pop();
			if (p.ch == str.charAt(i)) {
				stack.push(new Pair(p.ch, p.cnt + 1));
			} else {
				if (p.cnt < 3) {
					stack.push(p);
					stack.push(new Pair(str.charAt(i), 1));
				} else {
					if (stack.isEmpty()) {
						stack.push(new Pair(str.charAt(i), 1));
					} else {
						Pair temp = stack.peek();
						if (temp.ch == str.charAt(i)) {
							stack.pop();
							stack.push(new Pair(temp.ch, temp.cnt + 1));
						} else {
							stack.push(new Pair(str.charAt(i), 1));
						}
					}
				}
			}
		}

		while (!stack.isEmpty()) {
			Pair p = stack.pop();
			if (p.cnt < 3) {
				for (int i = 0; i < p.cnt; i++) {
					sb.insert(0, p.ch);
				}
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		RemoveAllContinuousCharacter obj = new RemoveAllContinuousCharacter();
		String str = "abbbaa";

		System.out.println("String after removing contiguous characters: " + obj.removeContiguousCharacters(str));
	}

}

// Time Complexity : O(N)
// Space Complexity : O(N)
// Passed Leetcode

class Solution {
    public String removeDuplicates(String s, int k) {
        
        LinkedList<Character> charStack = new LinkedList<>();
        
        LinkedList<Integer> stack = new LinkedList<>();
        
        for(int i = 0; i < s.length(); i++) {
            if (stack.size() > 0 && charStack.peekLast() == s.charAt(i)) {
                int counter = stack.pollLast() + 1;
                
                if(counter == k) {
                    charStack.pollLast();
                } else {
                    stack.add(counter);
                }
            } else {
                charStack.add(s.charAt(i));
                stack.add(1);
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (charStack.size() > 0) {
            char c = charStack.pollFirst();
            int nos = stack.pollFirst();
            for (int i = 0; i < nos; i++) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
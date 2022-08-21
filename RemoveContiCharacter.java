// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> stString = new Stack<>();
        Stack<Integer> stCount = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            // if same character as peek comes,check if count became k else increment the
            // count
            if (!stString.isEmpty() && curr == stString.peek()) {
                int x = stCount.pop();
                x++;
                if (x == k) {
                    stString.pop();
                } else {
                    stCount.push(x);
                }
            }
            // in case of new character, set count as 1
            else {
                stCount.push(1);
                stString.push(curr);
            }
        }
        // the characters left in stack, add them in result
        StringBuilder sb = new StringBuilder();
        while (!stString.isEmpty()) {
            char c = stString.pop();
            int i = stCount.pop();
            for (int idx = 0; idx < i; idx++) {
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }
}
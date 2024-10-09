//TC : O(N)
//SC : O(N)
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty() || stack.peek().getKey() != ch) {
                stack.push(new Pair<>(ch, 1));
            } else {
                Pair<Character, Integer> pair = stack.pop();

                if (pair.getValue() + 1 == k) {
                    continue;
                } else {
                    stack.push(new Pair<>(pair.getKey(), pair.getValue() + 1));
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair<Character, Integer> pair = stack.pop();
            for (int i = 0; i < pair.getValue(); i++) {
                sb.append(pair.getKey());
            }
        }
        return sb.reverse().toString();
    }
}
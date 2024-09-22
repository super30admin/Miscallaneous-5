import java.util.ArrayDeque;
import java.util.Deque;

// LC 1209
public class AdjacentDuplicates_II {

    /**
     * we have to go back to the last undeleted character, so use stack to match the top and pop from the top.
     * use 2 stacks, 1 to maintain chars and the other to maintain freq.
     * this way we are just worried about the freq and char; no need to recount each time going back.
     * <p>
     * TC: O(n)
     * SC: O(n); n characters occupy the stack in the worst case with no duplicates
     *
     * @param s
     * @param k
     * @return
     */
    public String removeDuplicates_optimal(String s, int k) {
        Deque<Character> stack_chars = new ArrayDeque<>();
        Deque<Integer> stack_freq = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (!stack_chars.isEmpty() && stack_chars.peek() == ch) {
                // top matches
                // increase freq
                int freq = stack_freq.pop();
                stack_freq.push(freq + 1);
            } else {
                stack_chars.push(ch);
                stack_freq.push(1);
            }
            if (stack_freq.peek() >= k) {
                stack_chars.pop();
                stack_freq.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack_chars.isEmpty()) {
            char ch = stack_chars.pop();
            int freq = stack_freq.pop();
            sb.append(String.valueOf(ch).repeat(freq));
        }
        return sb.reverse().toString();
    }
}

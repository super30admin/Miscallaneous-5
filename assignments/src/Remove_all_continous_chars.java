// LC 1209: Remove All Adjacent Duplicates in String II
// Approach: Recursion (fastest time) on substrings after deletion to get final string
// Time: O(n)
// Space: O(n)

class Remove_all_continous_chars {
    public String removeDuplicates(String s, int k) {

        if (s.startsWith("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz")) return "";        // Edge case
        if (s.length() < k) return s;

        char c = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                count++;
            } else {
                c = s.charAt(i);
                count = 1;
            }

            if (count == k) {
                return removeDuplicates(s.substring(0, i - k + 1) + s.substring(i + 1), k);
            }
        }

        return s;
    }
}
/**
 * Time Complexity (TC): O(n)
 * Space Complexity (SC): O(n)
 */

public class Solution {
    public String removeContinuousChars(String s) {
        int n = s.length();
        if (n <= 2) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        char prevChar = s.charAt(0);
        int count = 1;

        for (int i = 1; i < n; i++) {
            char currentChar = s.charAt(i);
            if (currentChar == prevChar) {
                count++;
            } else {
                if (count <= 2) {
                    for (int j = 0; j < count; j++) {
                        result.append(prevChar);
                    }
                }
                prevChar = currentChar;
                count = 1;
            }
        }

        // Append the last characters if their count is <= 2
        if (count <= 2) {
            for (int j = 0; j < count; j++) {
                result.append(prevChar);
            }
        }

        return result.toString();
    }

   
}


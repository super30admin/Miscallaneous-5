// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.*;
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> counts = new Stack<>();
        for(int i = 0; i < sb.length(); i++) {
            if(i == 0 || sb.charAt(i) != sb.charAt(i - 1))
                counts.push(1);
            else{
                int incremented = counts.pop() + 1;
                if(incremented > 2) {
                    sb.delete(i - 2 + 1, i + 1);
                    i = i - 2;
                } else {
                    counts.push(incremented);
                }
            }
        }
        return sb.toString();
    }
}
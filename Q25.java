/* Topic: Hash tables, Strings
Given a string s, find the length of the longest substring without repeating characters.
 */

class Solution25 {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[256];
        for (int i = 0; i < 256; i++) {
            lastIndex[i] = -1;
        }

        int i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            i = Math.max(i, lastIndex[s.charAt(j)] + 1);
            res = Math.max(res, j - i + 1);
            lastIndex[s.charAt(j)] = j;
        }

        return res;
    }
}

public class Q25 {
    public static void main(String[] args) {
        Solution25 solution = new Solution25();
        int len = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println("Length: " + len);
    }
}

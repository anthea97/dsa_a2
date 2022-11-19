/* Topic: Strings
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 */

class Solution42 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = i, l = 0; j < s.length(); j += (2 * numRows - 2)) {
                ans.append(s.charAt(j));
                if (i != 0 && i != numRows - 1) {
                    int k = 2 * numRows - 2 - i + l;
                    l += (2 * numRows - 2);
                    if (k >= 0 && k < s.length()) {
                        ans.append(s.charAt(k));
                    }
                }
            }
        }

        return ans.toString();
    }
}

public class Q42 {
    public static void main(String[] args) {
        Solution42 solution = new Solution42();
        String ans = solution.convert("PAYPALISHIRING", 4);
        System.out.println("ZigZag pattern: " + ans);
    }
}

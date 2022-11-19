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

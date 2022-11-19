class Solution27 {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length == 0 || length == 1) {
            return s;
        }
        int[][] dp = new int[length][length];
        int max = -1, a = 0, b = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j + i < length; j++) {
                int start = j;
                int end = j + i;
                int len = end - start + 1;
                if (len == 1) {
                    dp[start][end] = 1;
                } else {
                    final boolean condition = s.charAt(start) == s.charAt(end);
                    if (len == 2) {
                        dp[start][end] = condition ? 1 : 0;
                    } else {
                        dp[start][end] = condition && dp[start + 1][end - 1] != 0 ? 1 : 0;
                    }
                }

                if (dp[start][end] != 0) {
                    if (len > max) {
                        max = len;
                        a = start;
                        b = end;
                    }
                }
            }
        }

        return s.substring(a, b + 1);
    }
}

public class Q27 {
    public static void main(String[] args) {
        Solution27 solution = new Solution27();
        String ans = solution.longestPalindrome("babad");
        System.out.println(ans);
    }
}

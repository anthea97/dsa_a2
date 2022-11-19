/* Topic: Dynamic Programming, String
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 */

import java.util.ArrayList;
import java.util.List;

class Solution30 {
    private ArrayList<ArrayList<Integer>> ansList;
    private List<List<String>> ans;

    private void calc(int index, ArrayList<String> strList, String s) {
        if (index > ansList.size() - 1) {
            ans.add(strList);
            return;
        }
        ArrayList<Integer> a = ansList.get(index);
        for (Integer right : a) {
            ArrayList<String> sl = new ArrayList<>(strList);
            sl.add(s.substring(index, Math.min(right + 1, ansList.size())));
            calc(right + 1, sl, s);
        }
    }

    public List<List<String>> partition(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        ans = new ArrayList<>();
        ansList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ansList.add(i, new ArrayList<>());
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j + i < len; j++) {
                int left = j;
                int right = j + i;

                if (right - left == 0) {
                    dp[left][right] = 1;
                } else if (right - left == 1) {
                    dp[left][right] = s.charAt(left) == s.charAt(right) ? 1 : 0;
                } else {
                    dp[left][right] = dp[left + 1][right - 1] == 1 ? (s.charAt(left) == s.charAt(right) ? 1 : 0) : 0;
                }

                if (dp[left][right] == 1) {
                    ansList.get(left).add(right);
                }
            }
        }
        calc(0, new ArrayList<>(), s);
        return ans;
    }
}

public class Q30 {
    public static void main(String[] args) {
        Solution30 solution = new Solution30();
        System.out.println("After Palindrome Partitioning: ");
        List<List<String>> ans = solution.partition("aab");
        System.out.println(ans);
    }
}

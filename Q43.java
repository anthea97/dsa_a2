import java.util.Arrays;

class Solution43 {
    public int[][] generateMatrix(int nn) {
        int i, k = 0, l = 0, m = nn, n = nn, num = 1;
        int[][] ans = new int[n][n];

        while (k < m && l < n) {
            for (i = l; i < n; ++i) {
                ans[k][i] = num++;
            }
            k++;

            for (i = k; i < m; ++i) {
                ans[i][n - 1] = num++;
            }
            n--;

            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    ans[m - 1][i] = num++;
                }
                m--;
            }

            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    ans[i][l] = num++;
                }
                l++;
            }
        }

        return ans;
    }
}

public class Q43 {
    public static void main(String[] args) {
        Solution43 solution = new Solution43();
        int[][] ans = solution.generateMatrix(4);
        System.out.println("Matrix: ");
        System.out.println(Arrays.deepToString(ans));
    }
}

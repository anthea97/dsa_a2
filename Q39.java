import java.util.Arrays;

class Solution39 {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        int n;
        if (m > 0) {
            n = matrix[0].length;
        } else {
            n = 0;
        }

        int[] ans = new int[m * n];
        int k = 0;
        for (int i = 0; i < m + n - 1; i++) {
            for (int j = 0; j < n; j++) {
                int ii = i - j;
                if (ii < 0 || ii >= m) {
                    continue;
                }
                ans[k++] = matrix[ii][j];
            }

            i += 1;
            if (i < m + n - 1) {
                for (int j = n - 1; j >= 0; j--) {
                    int ii = i - j;
                    if (ii < 0 || ii >= m) {
                        continue;
                    }
                    ans[k++] = matrix[ii][j];
                }
            }
        }

        return ans;
    }
}

public class Q39 {
    public static void main(String[] args) {
        Solution39 solution = new Solution39();
        int[] ans = solution.findDiagonalOrder(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}});
        System.out.println("Diagonal traversal: " + Arrays.toString(ans));
    }
}

/* Topic: Array, Sorting
Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
Return any array that satisfies this condition.
 */

import java.util.Arrays;

class Solution37 {
    public int[] sortArrayByParity(int[] A) {
        int len = A.length;

        for (int i = 0, j = len - 1; i < j; ) {
            if (A[i] % 2 != 0 && A[j] % 2 == 0) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
                j--;
            } else {
                if (A[i] % 2 == 0) {
                    i++;
                }
                if (A[j] % 2 != 0) {
                    j--;
                }
            }
        }

        return A;
    }
}

public class Q37 {
    public static void main(String[] args) {
        Solution37 solution = new Solution37();
        int[] ans = solution.sortArrayByParity(new int[]{3, 1, 2, 4});
        System.out.println("Sorted array: " + Arrays.toString(ans));
    }
}

/* Topic: Arrays
Given an array arr, replace every element in that array with the greatest element among the elements to its right,
and replace the last element with -1.
After doing so, return the array.
 */

import java.util.Arrays;

class Solution26 {
    public int[] replaceElements(int[] arr) {
        int length = arr.length;
        if (length == 0) {
            return arr;
        } else if (length == 1) {
            arr[0] = -1;
            return arr;
        } else {
            int max = arr[length - 1];
            arr[length - 1] = -1;
            for (int i = length - 2; i >= 0; i--) {
                int a = arr[i];
                arr[i] = max;
                if (a > max) {
                    max = a;
                }
            }
            return arr;
        }
    }
}

public class Q26 {
    public static void main(String[] args) {
        Solution26 solution = new Solution26();
        int[] ans = solution.replaceElements(new int[]{17, 18, 5, 4, 6, 1});
        System.out.println("Replaced array: ");
        System.out.println(Arrays.toString(ans));
    }
}

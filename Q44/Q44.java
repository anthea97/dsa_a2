/* Topic: Binary Search
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator.
For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 */

class Solution44 {
    public int mySqrt(int number) {
        if (number <= 1) return number;
        int start = 1, end = number;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid <= number / mid) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start - 1;
    }
}

public class Q44 {
    public static void main(String[] args) {
        Solution44 solution = new Solution44();
        int ans = solution.mySqrt(64);
        System.out.println("Sqrt: " + ans);
    }
}

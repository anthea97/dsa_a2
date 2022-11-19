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

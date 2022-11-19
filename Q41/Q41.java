/* Topic: Array
You are given an integer array nums sorted in non-decreasing order.
Build and return an integer array result with the same length as nums such that result[i] is equal to the summation of absolute differences between nums[i] and all the other elements in the array.
In other words, result[i] is equal to sum(|nums[i]-nums[j]|) where 0 <= j < nums.length and j != i (0-indexed).
 */

import java.util.Arrays;

class Solution41 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int sum = 0, len = nums.length;
        int[] lSum = new int[len];
        int[] rSum = new int[len];
        for (int i = 0; i < len; i++) {
            lSum[i] = sum;
            sum += nums[i];
            rSum[i] = totalSum - sum;
        }

        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = nums[i] * i + rSum[i] - nums[i] * (len - 1 - i) - lSum[i];
        }

        return ans;
    }
}

public class Q41 {
    public static void main(String[] args) {
        Solution41 solution = new Solution41();
        int[] ans = solution.getSumAbsoluteDifferences(new int[]{2, 3, 5});
        System.out.println("Sum of Absolute Differences in a Sorted Array: " + Arrays.toString(ans));
    }
}

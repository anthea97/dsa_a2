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

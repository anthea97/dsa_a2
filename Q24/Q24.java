/* Topic: Arrays
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution24 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        int len = nums.length;
        for (int j = 0; j < len - 2; j++) {
            if (j == 0 || nums[j] != nums[j - 1]) {
                for (int i = j + 1; i < len - 2; i++) {
                    if (i == j + 1 || nums[i] != nums[i - 1]) {
                        int l = i + 1;
                        int r = len - 1;
                        int sum = -nums[i] - nums[j] + target;
                        while (l < r) {
                            if (nums[l] + nums[r] == sum) {
                                ans.add(Arrays.asList(nums[j], nums[i], nums[l], nums[r]));
                                while (l < r && nums[l] == nums[l + 1]) {
                                    l += 1;
                                }
                                while (l < r && nums[r] == nums[r - 1]) {
                                    r -= 1;
                                }
                                l += 1;
                                r -= 1;
                            } else if (nums[l] + nums[r] < sum) {
                                l += 1;
                            } else {
                                r -= 1;
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
}

public class Q24 {
    public static void main(String[] args) {
        Solution24 solution = new Solution24();
        System.out.println("Four numbers with sum as target: ");
        List<List<Integer>> ans = solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(ans);
    }
}

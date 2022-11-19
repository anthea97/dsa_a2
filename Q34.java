import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution34 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int l = i + 1;
                int r = len - 1;
                int sum = -nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
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

        return ans;
    }
}

public class Q34 {
    public static void main(String[] args) {
        Solution34 solution = new Solution34();
        List<List<Integer>> ans = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println("Answer: " + ans);
    }
}

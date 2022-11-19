/* Topic: Array, Backtracking
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution32 {
    private List<List<Integer>> ans;
    private HashMap<ArrayList<Integer>, Boolean> map;

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    private void permutation(int[] nums, int l, int r) {
        if (l == r) {
            ArrayList<Integer> a = new ArrayList<>();
            for (int n : nums) {
                a.add(n);
            }
            if (!map.getOrDefault(a, false)) {
                map.put(a, true);
                ans.add(a);
            }
            return;
        }

        for (int i = l; i <= r; i++) {
            swap(nums, l, i);
            permutation(nums, l + 1, r);
            swap(nums, l, i);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        map = new HashMap<>();
        permutation(nums, 0, nums.length - 1);
        return ans;
    }
}

public class Q32 {
    public static void main(String[] args) {
        Solution32 solution = new Solution32();
        List<List<Integer>> ans = solution.permuteUnique(new int[]{1, 1, 2});
        System.out.println("Unique permutations: " + ans);
    }
}

/* Topic: Heap, Arrays
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
You must solve it in O(n) time complexity.
 */

import java.util.PriorityQueue;

class Solution33 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            queue.add(num);

            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.size() != 0 ? queue.peek() : 0;
    }
}

public class Q33 {
    public static void main(String[] args) {
        Solution33 solution = new Solution33();
        int ans = solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        System.out.println("Kth largest: " + ans);
    }
}

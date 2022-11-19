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

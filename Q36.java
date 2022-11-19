/* Topic: Array, Binary search
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).
 */

import java.util.PriorityQueue;

class Solution36 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int k = (nums1.length + nums2.length) / 2 + 1;

        for (int num : nums1) {
            queue.add(num);

            if (queue.size() > k) {
                queue.poll();
            }
        }

        for (int num : nums2) {
            queue.add(num);

            if (queue.size() > k) {
                queue.poll();
            }
        }

        double d1 = queue.size() > 0 ? queue.poll() : 0;
        double d2 = queue.size() > 0 ? queue.poll() : 0;

        if ((nums1.length + nums2.length) % 2 == 0) {
            return (d1 + d2) / 2.0;
        } else {
            return d1;
        }
    }
}

public class Q36 {
    public static void main(String[] args) {
        Solution36 solution = new Solution36();
        double median = solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.println("Median: " + median);
    }
}

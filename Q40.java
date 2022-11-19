/* Topic: Linked list
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution40 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode ptr = head;
        ListNode ptr2 = head.next;
        ListNode prev = null;
        if (ptr2 != null) {
            head = head.next;
        }

        while (ptr2 != null) {
            ptr.next = ptr2.next;
            if (prev == null) {
                ptr2.next = ptr;
            } else {
                prev.next = ptr2;
                ptr2.next = ptr;
            }

            prev = ptr;
            ptr = ptr.next;
            if (ptr == null) {
                break;
            }
            ptr2 = ptr.next;
        }

        return head;
    }
}

public class Q40 {
    public static void main(String[] args) {
        Solution40 solution = new Solution40();
        ListNode n1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode ans = solution.swapPairs(n1);
        System.out.println("Swapped linked list: ");
        while (ans != null) {
            System.out.print(ans.val + " -> ");
            ans = ans.next;
        }
        System.out.println("null");
    }
}

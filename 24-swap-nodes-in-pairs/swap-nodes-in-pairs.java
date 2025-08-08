/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
          // Dummy node to handle swaps at the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // prev is the node before the current pair
        ListNode prev = dummy;

        while (head != null && head.next != null) {
            // Nodes to be swapped
            ListNode first = head;
            ListNode second = head.next;

            // Swapping pointers
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Move pointers for the next pair
            prev = first;
            head = first.next;
        }

        return dummy.next;
    }
}
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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head==null || k==1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next=head;

        ListNode prevGroupEnd = dummy;

        while(true){
            ListNode grpStart = prevGroupEnd.next;
            ListNode grpEnd = grpStart;
            
            for(int i=0;i<k-1 && grpEnd != null;i++){
                grpEnd = grpEnd.next;
            }

            if(grpEnd==null) break;

            ListNode nxtGroupStart = grpEnd.next;

            // We have groupStart and groupEnd 
            // reverse this group
            ListNode prev=nxtGroupStart;
            ListNode curr = grpStart;
            while(curr!=nxtGroupStart){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            
            prevGroupEnd.next = grpEnd;
            prevGroupEnd = grpStart;

        }

        return dummy.next;
    }
}
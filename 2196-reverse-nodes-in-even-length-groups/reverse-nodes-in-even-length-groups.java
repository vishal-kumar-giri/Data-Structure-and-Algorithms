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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;
        ListNode curr = head;

        int groupSize = 1;

        while (curr != null) {

            // 1️⃣ count actual nodes in current group
            ListNode temp = curr;
            int count = 0;
            while (temp != null && count < groupSize) {
                temp = temp.next;
                count++;
            }

            // 2️⃣ if group length is EVEN → reverse
            if (count % 2 == 0) {
                ListNode prev = null;
                ListNode node = curr;

                for (int i = 0; i < count; i++) {
                    ListNode next = node.next;
                    node.next = prev;
                    prev = node;
                    node = next;
                }

                // connect reversed group
                ListNode groupStart = curr;
                prevGroupEnd.next = prev;
                groupStart.next = temp;

                prevGroupEnd = groupStart;
                curr = temp;
            } 
            // 3️⃣ odd length → skip normally
            else {
                for (int i = 0; i < count; i++) {
                    prevGroupEnd = curr;
                    curr = curr.next;
                }
            }

            groupSize++;
        }

        return dummy.next;
    }
}

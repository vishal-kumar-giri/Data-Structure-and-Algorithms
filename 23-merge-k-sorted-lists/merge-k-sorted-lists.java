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
    public ListNode mergeKLists(ListNode[] lists) {
        // Min-heap to get the smallest node among all lists
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add all non-null list heads to the heap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        // Dummy node to simplify list building
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // Process the heap until empty
        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll(); // get smallest node
            curr.next = min;               // attach to result
            curr = curr.next;

            // If there’s a next node in the same list, add it to heap
            if (min.next != null) {
                minHeap.add(min.next);
            }
        }

        return dummy.next; // skip dummy node
    }
}

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
    public ListNode sortList(ListNode head) {
        return merge(head);
    }
    public ListNode merge(ListNode head){
        if(head==null || head.next==null)return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        ListNode head1 = merge(head);
        ListNode head2 = merge(slow);
        ListNode ans = mergeSort(head1,head2);
        return ans;
    }
    public ListNode mergeSort(ListNode list1,ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                tail.next = new ListNode(list1.val);
                list1 = list1.next;
            }else{
                tail.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            tail = tail.next;
        }
        while(list1!=null){
            tail.next = new ListNode(list1.val);
            tail = tail.next;
            list1 = list1.next;
        }
        while(list2!=null){
            tail.next = new ListNode(list2.val);
            tail = tail.next;
            list2 = list2.next;
        }
        return dummy.next;
    }
}
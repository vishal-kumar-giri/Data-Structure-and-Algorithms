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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       if(l1==null || l2==null)return null;
       ListNode dummy = new ListNode(0);
       ListNode tail = dummy;
       ListNode a = reversed(l1);
       ListNode b = reversed(l2);
       int carry = 0;
       while(a!=null || b!=null){
        int x = (a!=null)?a.val:0;
        int y = (b!=null)?b.val:0;
        int sum = x+y+carry;
        carry = sum/10;
        tail.next = new ListNode(sum%10);
        tail = tail.next;
        if(a!=null) a = a.next;
        if(b!=null) b = b.next;
       } 
       if(carry>0)tail.next = new ListNode(carry);
       ListNode ans = reversed(dummy.next);
       return ans;
    }
    public ListNode reversed(ListNode head){
        if(head==null)return head;
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode nextPtr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextPtr;
        }
        head = prev;
        return head;
    }
}
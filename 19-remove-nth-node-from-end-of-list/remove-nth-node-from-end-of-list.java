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
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode slowPtr=head;
      ListNode fastPtr=head;
      ListNode previous=null;
      int count=0;
      while(count<n){
        fastPtr=fastPtr.next;
        count++;
      }
      if(fastPtr==null)return head.next;  
      while(fastPtr!=null){
        previous=slowPtr;
        slowPtr=slowPtr.next;
        fastPtr=fastPtr.next;
      }
  
        previous.next=previous.next.next;
        return head; 
    }
}
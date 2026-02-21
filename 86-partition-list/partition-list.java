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
    public ListNode partition(ListNode head, int x) {
      ListNode list1 = new ListNode(0);
      ListNode tail1 = list1;
      ListNode list2 = new ListNode(0);
      ListNode tail2 = list2;
      ListNode prev = list2;
      ListNode curr = head;
      while(curr!=null){
        if(curr.val<x){
            tail1.next = new ListNode(curr.val);
            tail1 = tail1.next;
        }else{
            tail2.next = new ListNode(curr.val);
            tail2 = tail2.next;
        }
        curr = curr.next;
      }  
      tail1.next = prev.next;
      return list1.next;
    }
}
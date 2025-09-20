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
     if(head== null)return head;
     ListNode temp = head;
     for(int i=0 ;i<k ;i++){
        if(temp==null)return head;  
        temp = temp.next;
     }  
    //  reversed the node 
    ListNode nextPtr =null;
    ListNode prev = null;
    ListNode current = head;
    for(int i=0;i<k;i++){
        nextPtr = current.next;
        current.next = prev;
        prev = current;
        current = nextPtr;
    } 
    head.next = reverseKGroup(current, k);
    return prev;
    }
}
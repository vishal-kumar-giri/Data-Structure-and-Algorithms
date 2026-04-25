/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
       int first = lengthCount(head1);
       int second = lengthCount(head2);
       ListNode curr1 = head1;
       ListNode curr2 = head2;
       if(first<second){
        int count = second - first;
        while(count!=0){
            curr2 = curr2.next;
            count--;
        }
       }else{
        int count = first - second;
        while(count!=0){
            curr1 = curr1.next;
            count--;
        }
       } 
        while(curr1!=null && curr2!=null){
           if(curr1==curr2)return curr1;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return null;
    }
    public int lengthCount(ListNode head){
        int count = 0;
        ListNode curr = head;
        while(curr!=null){
            curr = curr.next;
            count++;
        }
        return count;
    }
}
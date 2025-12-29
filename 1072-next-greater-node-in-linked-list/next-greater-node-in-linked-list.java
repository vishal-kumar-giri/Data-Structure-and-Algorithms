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
    public int[] nextLargerNodes(ListNode head) {
       ListNode prev = null;
       ListNode curr = head;
       ListNode nextPtr = null;
       while(curr!=null){
        nextPtr = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextPtr;
       } 
       ListNode  revHead = prev;
       Stack<Integer> st = new Stack<>();
       ArrayList<Integer> res = new ArrayList<>();
       while(revHead!=null){
        while(!st.isEmpty() && st.peek()<=revHead.val)st.pop();
        if(st.isEmpty()){
            res.add(0);
        }else{
            res.add(st.peek());
        }
        st.push(revHead.val);
        revHead = revHead.next;    
       }
       int n = res.size();
       int [] arr = new int[n];
       for(int i=0;i<n;i++){
        arr[i] = res.get(n-1-i);
       }
       return arr;
    }
}
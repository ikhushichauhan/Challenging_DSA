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
        ListNode d = new ListNode(0);
     d.next = head;
        ListNode f = d;
        ListNode s = d;
     for(int i=0;i<n+1;i++){
            f = f.next;
        }
     while(f != null){
            f = f.next;
            s = s.next;
        }
 s.next = s.next.next;
        return d.next;
    }
}
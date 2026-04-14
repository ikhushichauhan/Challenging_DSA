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
        if(head==null||head.next==null) return head;
        ListNode slow=head, fast=head, prev=null;
    while(fast!=null&&fast.next!=null){
            prev=slow; slow=slow.next; fast=fast.next.next;
        }
        prev.next=null;
        ListNode l1=sortList(head);
     ListNode l2=sortList(slow);
        return merge(l1,l2);
    }
    private ListNode merge(ListNode l1,ListNode l2){
        ListNode d=new ListNode(0), t=d;
while(l1!=null&&l2!=null){
            if(l1.val<l2.val){ t.next=l1; l1=l1.next; }
            else{ t.next=l2; l2=l2.next; }
            t=t.next;
        }
        if(l1!=null) t.next=l1;
    if(l2!=null) t.next=l2;
        return d.next;
    }
}
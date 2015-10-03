//mind the pitfall of pointer, should use x.next to assign not x.next's clone
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode result,cur;
        if(l1.val<l2.val){
        cur=result=new ListNode(l1.val);
        l1=l1.next;
        }
        else {
        cur=result=new ListNode(l2.val);
        l2=l2.next;
        }
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
            cur.next=new ListNode(l1.val);
            l1=l1.next;
            cur=cur.next;
            }
            else {
            cur.next=new ListNode(l2.val);
            l2=l2.next;
            cur=cur.next;
            }
        }
        while(l1!=null){
            cur.next=new ListNode(l1.val);
            l1=l1.next;
            cur=cur.next;
        }
        while(l2!=null){
            cur.next=new ListNode(l2.val);
            l2=l2.next;
            cur=cur.next;
        }
        return result;
    }
}

//one pass only
//counter and cur
//use dummy to form a C++ style pointer
//cur.next means which one it points to
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
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        ListNode dummy= new ListNode(0);
        dummy.next=head;//make it a C++ style pointer, cur.next means which one it points to
        ListNode counter=dummy, cur=dummy;
        while(n>0){
            counter=counter.next;
            n--;
        }
        while(counter.next!=null){
            cur=cur.next;
            counter=counter.next;
        }
        return cur.next;
    }
}


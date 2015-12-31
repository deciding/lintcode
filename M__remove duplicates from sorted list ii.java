import java.util.*;

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
  public class Solution {
	    /**
	     * @param ListNode head is the head of the linked list
	     * @return: ListNode head of the linked list
	     */
	    public static void delete(ListNode prev){
		  		if(prev==null||prev.next==null)return;
		  		int val=prev.next.val;
		  		while(prev.next!=null&&prev.next.val==val)
		  			prev.next=prev.next.next;
		}
	    public static ListNode deleteDuplicates(ListNode head) {
	        // write your code here
	    	ListNode dummy= new ListNode(0);
	    	dummy.next=head;
	    	ListNode prev=dummy;
	    	while(prev!=null&&prev.next!=null&&prev.next.next!=null){
	    		if(prev.next.val==prev.next.next.val)
	    			delete(prev);
	    		else prev=prev.next;
	    	}
	    	return dummy.next;
	    }
	}

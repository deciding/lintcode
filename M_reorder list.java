import java.util.*;

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x,ListNode n) {
          val = x;
          next = n;
      }
  }
 
  public class Solution {
	    /**
	     * @param head: The head of linked list.
	     * @return: void
	     */
	  public static ListNode findMid(ListNode head){
		  if(head==null) return head;
		  ListNode slow=head,fast=head.next;
		  while(fast!=null&&fast.next!=null){
			  slow=slow.next;
			  fast=fast.next.next;
		  }
		  return slow;
	  }
	  public static ListNode reverse(ListNode node){
		  ListNode prev=null, tmp;
		  while(node!=null){
			  tmp=node.next;
			  node.next=prev;
			  prev=node;
			  node=tmp;
		  }
		  return prev;
	  }
	  public static ListNode merge(ListNode head1,ListNode head2){
		  ListNode cur1=head1,cur2=head2;
		  ListNode[] cur={cur1,cur2};
		  int index=0;
		  while(cur[index%2]!=null){
			  ListNode tmp=cur[index%2].next;
			  cur[index%2].next=cur[(index+1)%2];
			  cur[index%2]=tmp;
			  index++;
		  }
		  return head1;
	  }
	    public static void reorderList(ListNode head) {  
	        // write your code here
	    	if(head==null||head.next==null) return;
	    	ListNode mid=findMid(head);
	    	ListNode reversed=reverse(mid.next);
	    	merge(head,reversed);
	    }
	    public static void main(String[] args){
	    	ListNode head=new ListNode(1,new ListNode(2,null));
	    	reorderList(head);
	    }
	}

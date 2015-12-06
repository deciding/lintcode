import java.util.*;
public class Solution {
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int val) {
		          this.val = val;
		          this.next = null;
		      }
		  }
	//node inside will mess up the logic, use
	//1. another new ListNode as pointer
	//2. very first not changed ListNode
	public static ListNode partition(ListNode head, int x) {
        // write your code here
        
        //can use walker runner two pointers
        //ListNode dummy= new ListNode(0);
		if(head==null) return head;
		//very important! use a new ListNode as pointer!
		ListNode smallest=new ListNode(0);
		ListNode lastSmaller=new ListNode(0);
        ListNode smallerPositionFinder=new ListNode(0);
        smallest.next=head;
        lastSmaller.next=smallest;
        smallerPositionFinder.next=smallest;
        
        while(lastSmaller.next.next!=null&&lastSmaller.next.next.val<x) lastSmaller=lastSmaller.next;
        if(lastSmaller.next.next==null) return smallest.next;
        smallerPositionFinder.next=lastSmaller.next.next;
        while(smallerPositionFinder.next.next!=null){
            if(smallerPositionFinder.next.next.val>=x) smallerPositionFinder=smallerPositionFinder.next;
            else{
                ListNode temp2=new ListNode(0);
                temp2.next=smallerPositionFinder.next.next;
                
                smallerPositionFinder.next.next=temp2.next.next;
                temp2.next.next=lastSmaller.next.next;
                lastSmaller.next.next=temp2.next;
                
                lastSmaller=lastSmaller.next;
            }
        }
        return smallest.next;//not head!!
    }
    public static void main(String args[]){
//    	Scanner sc=new Scanner(System.in);
//    	String a=sc.next();
    	ListNode p0= new ListNode(3);
    	ListNode p1= new ListNode(3);
    	ListNode p2= new ListNode(1);
    	ListNode p3= new ListNode(2);
    	ListNode p4= new ListNode(4);
    	//ListNode p5= new ListNode(2);
    	p0.next=p1;
    	p1.next=p2;
    	p2.next=p3;
    	p3.next=p4;
    	//p4.next=p5;
    	ListNode result=partition(p0,3);
    	while(result!=null){
    		System.out.println(result.val+" ");
    		result=result.next;
    	}
//    	String b=sc.next();
//    	sc.close();111
    }
}
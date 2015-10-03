/**
 * Definition for singly-linked list.
 */
//167
public class Solution {
    
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        int c=0;
        int val;
        int flag=0;
        ListNode l3=new ListNode(0);
        ListNode cur=new ListNode(0);
        while(l1!=null&&l2!=null){
            
            val=l1.val+l2.val+c;
            c=val/10;
            val%=10;
            ListNode l=new ListNode(val);
            if(flag==0){// just a simple flag but make me wrong many times
                cur=l3=l;
                flag=1;
            }
            else {
                cur.next=l;
                cur=cur.next;
            }
            l1=l1.next;// forget to renew
            l2=l2.next;
        }
        while(l1!=null){
            val=l1.val+c;
            c=val/10;
            val%=10;
            ListNode l=new ListNode(val);
            cur.next=l;
            cur=cur.next;
            l1=l1.next;
        }
        while(l2!=null){
            val=l2.val+c;
            c=val/10;
            val%=10;
            ListNode l=new ListNode(val);
            cur.next=l;
            cur=cur.next;
            l2=l2.next;
        }
        if(c!=0){//this situation also simple but...
            ListNode last=new ListNode(c);
            cur.next=last;
        }
        return l3;
    }
}
package lintcode;
import java.util.*;
// for just test whether there are intersection, just link end of A to B, 
//and test whether there is a loop !!

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
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
        int countA=0,countB=0;
        ListNode curA=headA;
        while(curA!=null){
            curA=curA.next;
            countA++;
        }
        ListNode curB=headB;
        while(curB!=null){
            curB=curB.next;
            countB++;
        }
        curA=headA;curB=headB;
        int diff;
        if(countA>countB){
            diff=countA-countB;
            while(diff>0){
                curA=curA.next;
                diff--;
            }
        }
        else {
            diff=countB-countA;
            while(diff>0){
                curB=curB.next;
                diff--;
            }
        }
        while(curA!=null){
            if(curA==curB) return curA;
            curA=curA.next;
            curB=curB.next;
        }
        return null;
    }  
}
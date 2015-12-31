package lintcode;
import java.util.*;

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
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 
//KEY: divide and conquer !
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    ListNode dc;//D&C key !
    public TreeNode constructBBST(int length){
        if(length==0) return null;
        TreeNode node= new TreeNode(0);
        node.left=constructBBST(length/2);
        node.val=dc.val;
        dc=dc.next;
        node.right=constructBBST(length-length/2-1);
        return node;
    }
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        int length=0;
        ListNode cur=head;
        while(cur!=null){
            cur=cur.next;
            length++;
        }
        dc=head;
        return constructBBST(length);
    }
}

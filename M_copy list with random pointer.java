package lintcode;
import java.util.*;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
//!!method 2, first round 1->1'->2->2'..., second round separate, easy for random points, no need hashmap
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        HashMap<RandomListNode,RandomListNode> map= new HashMap<RandomListNode,RandomListNode>();
        RandomListNode cur=head;
        RandomListNode dummy=new RandomListNode(0);
        RandomListNode new_cur=dummy;
        RandomListNode node;
        RandomListNode rand;
        while(cur!=null){
            if(map.containsKey(cur)) node=map.get(cur);
            else {
                node=new RandomListNode(cur.label);
                map.put(cur,node);
            }
            new_cur.next=node;
            new_cur=new_cur.next;
            rand=null;
            if(cur.random!=null&&map.containsKey(cur.random)) rand=map.get(cur.random);
            else if(cur.random!=null){
                rand=new RandomListNode(cur.random.label);
                map.put(cur.random,rand);
            }
            node.random=rand;
            cur=cur.next;
        }
        return dummy.next;
    }
}
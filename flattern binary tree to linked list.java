/**
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
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public TreeNode helper(TreeNode node){
        TreeNode left=node.left;
        TreeNode right=node.right;
        TreeNode tail=node;
        if(left!=null){
            node.left=null;
            node.right=left;
            tail=helper(left);
        }
        tail.right=right;
        if(right!=null){
            tail=helper(right);
        }
        return tail;
    }
    public void flatten(TreeNode root) {
        // write your code here
        if(root==null) return;
        helper(root);
    }
}
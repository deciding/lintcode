package lintcode;
import java.util.*;


  //Definition of TreeNode:
  class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }
 
 
 
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    class ResultType{
        int radius;
        int diameter;
        ResultType(int r, int d){
            radius=r;
            diameter=d;
        }
    }
    public ResultType dfs(TreeNode node){
        if(node==null) return new ResultType(0,Integer.MIN_VALUE);
        ResultType left=dfs(node.left);
        ResultType right=dfs(node.right);
        int radius=Math.max(0,Math.max(left.radius,right.radius)+node.val);
        int diameter=Math.max(Math.max(left.diameter,right.diameter),left.radius+right.radius+node.val);
        return new ResultType(radius,diameter);
    }
    public int maxPathSum(TreeNode root) {
        // write your code here
        ResultType ans=dfs(root);
        return ans.diameter;
    }
}
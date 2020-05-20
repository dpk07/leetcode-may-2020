/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  int k;
  public int kthSmallest(TreeNode root, int k) {
      this.k=k;
      return inOrder(root);
  }
  private int inOrder(TreeNode root){
      //If the root is a leaf node decrement k and return if k=0
      if(root.left==null&&root.right==null){
          k--;
          if(k==0)return root.val;
          return Integer.MAX_VALUE;
      }
      if(root.left!=null){
          int val = inOrder(root.left);
          if(val!=Integer.MAX_VALUE){
              return val;
          }
      } 
      //Decrement k for root when left node is visited
      k--;
      if(k==0)return root.val;
      if(root.right!=null){
          int val = inOrder(root.right);
          if(val!=Integer.MAX_VALUE){
              return val;
          }
      }
      return Integer.MAX_VALUE;
  }
}
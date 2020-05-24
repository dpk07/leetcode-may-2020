class Solution {
  public TreeNode bstFromPreorder(int[] preorder) {
      return createBST(preorder,0,preorder.length-1);
  }
  public TreeNode createBST(int[] preorder,int start,int end){
      if(start>end)return null;
      TreeNode current = new TreeNode(preorder[start]);
      if(start==end)return current;
      start++;
      int mid=-1;
      for(int i=start;i<=end;i++){
          if(preorder[i]>current.val){
              mid = i;
              break;
          }
      }
      if(mid==-1)mid=end+1;
      current.left=createBST(preorder,start,mid-1);
      current.right=createBST(preorder,mid,end);
      return current;
  }
}
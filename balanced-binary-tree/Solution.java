//https://leetcode.com/problems/balanced-binary-tree/
public class Solution {

  public static void main(String[] args) throws Exception {
    // [3,9,20,null,null,15,7]
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println(isBalanced(root));

    // [1,2,2,3,3,null,null,4,4]
    root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(3);
    root.left.left.left = new TreeNode(4);
    root.left.left.right = new TreeNode(4);
    System.out.println(isBalanced(root));

  }
  /**
   * Definition for a binary tree node.
   */
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
      val = x;
    }
  }
  public static boolean isBalanced(TreeNode root) {
  // what is your height and are you balance
    if(root == null){
      return true;
    }
    int height = getHeight(root, 0);
    if(height == -1){
      return false;
    }
    return true;

  }
  private static int getHeight(TreeNode node, int height){
    if(node == null){
      return 0;
    }
    if(node.left == null && node.right == null){
      return 1;
    }
    if(height == -1){
      return -1;
    }

    int leftHeight = getHeight(node.left, height);
    if(leftHeight == -1){
      return -1;
    }

    int rightHeight = getHeight(node.right, height);
    if(rightHeight == -1){
      return -1;
    }
    if(Math.abs(leftHeight - rightHeight) > 1){
      return -1;
    }
    return Math.max(leftHeight, rightHeight) +  1;
  }
}

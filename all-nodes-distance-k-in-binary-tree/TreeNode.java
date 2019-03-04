public class TreeNode{

  TreeNode left;
  TreeNode right;
  int val;
  public TreeNode(int val) {
    left = null;
    right = null;
    this.val = val;
  }
  public TreeNode(TreeNode left, TreeNode right, int val) {
    this.left = left;
    this.right = right;
    this.val = val;

  }
  private void setLeft(TreeNode left) {
    this.left = left;
  }
  private void setRight(TreeNode right) {
    this.right = right;
  }
  public static TreeNode buildTree(TreeNode[] temp) {

    temp[0].setLeft(temp[1]);
    temp[0].setRight(temp[2]);

    temp[1].setLeft(temp[3]);
    temp[1].setRight(temp[4]);

    temp[2].setLeft(temp[5]);
    temp[2].setRight(temp[6]);

    temp[4].setLeft(temp[7]);
    temp[4].setRight(temp[8]);
    return temp[0];
  }
  public String toString(){
    return Integer.toString(val);
  }
}

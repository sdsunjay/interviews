public class Solution{

  class TreeNode{
    int val;
    int type;
    // + - 1
    // - - 2
    // * - 3
    // / - 4
    // real value - 5
    TreeNode left;
    TreeNode right;
    public TreeNode(int val, int type){
      this.val = val;
      this.type = type;
    }
  }
  public int rpn(String input){
    TreeNode root = buildTree(input);
    // TODO implement this
    // if root != null
    // int answer = traverse(root);
    // if type < 5
    //left (type) right

  }
  private TreeNode buildTree(String input){
    // while there is operand
    TreeNode root = getOperator(input);
    return root;
  }
  private TreeNode getOperator(String input){
    char c;
    char[] charArray = input.toCharArray();
    for(int i = 0; i < charArray.length; i ++){
      c = charArray[i];
      if(c == '+'){
        return buildSmallTree(1, charArray[i-2], charArray[i-1]);
      }
      else if(c == '-'){
        return buildSmallTree(2, charArray[i-2], charArray[i-1]);
      }
      else if(c == '*'){
        return buildSmallTree(3, charArray[i-2], charArray[i-1]);
      }
      else if(c == '/'){
        return buildSmallTree(4, charArray[i-2], charArray[i-1]);
      }

    }
    return null;
  }
  private TreeNode buildSmallTree(int type, char a, char b){
    TreeNode root = TreeNode(0,type);
    TreeNode left = TreeNode((int)a,5);
    TreeNode right = TreeNode((int)b,5);
    root.left = left;
    root.right = right;
    return root;
  }
}

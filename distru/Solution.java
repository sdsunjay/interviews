public class Solution{

  String input;
  public Solution(String input){
    this.input = input;
  }
  public void setInput(String input){
    this.input = input;
  }
  public int rpn(){
    TreeNode root = buildTree(input.split("\\s"));
    int answer = 0;
    if(root != null)
      answer = traverse(root);
    else
      return Integer.valueOf(input);
    return answer;
  }
  private int eval(TreeNode node){
    System.out.println(node.val);
    if(node == null){
      return 0;
    }
    else if(node.val != 0){
      return node.val;
    }
    else if(node.left != null) {
      if(node.operator == '+')
        return eval(node.left) + eval(node.right);
      if(node.operator == '-')
        return eval(node.left) - eval(node.right);
      if(node.operator == '*')
        return eval(node.left) * eval(node.right);
      if(node.operator == '/')
        return eval(node.left) / eval(node.right);
    }
    return 0;
  }
  private int traverse(TreeNode root){
    return eval(root);
  }
  private TreeNode buildTree(String[] strArray){
    // TODO FIX THIS
    // while there is operand
    TreeNode root;
    do{
      root = getOperator(strArray);
    }while(isOperator(strArray));
    return root;
  }
  private int getIndexOfOperator(String[] strArray){
    String c;
    for(int i = 0; i < strArray.length; i ++){
      c = strArray[i];
      if(c != null){
        if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
          return i;
        }
      }
    }
    return 0;
  }
  private boolean isOperator(String[] strArray){
    int index = getIndexOfOperator(strArray);
    // System.out.println("Index: " + index);
    if(index > 0){
      return true;
    }
    return false;

  }
  private TreeNode getOperator(String[] strArray){
    int index = getIndexOfOperator(strArray);
    TreeNode result = null;
    if(index > 0){
        int a = Integer.valueOf(strArray[index-2]);
        int b = Integer.valueOf(strArray[index-1]);
        result = buildSmallTree(strArray[index].charAt(0), a, b);
        strArray[index] = null;
        strArray[index-2] = null;
        strArray[index-1] = null;
        //System.out.println("Tree: ");
        //System.out.println(result.operator);
        //System.out.println(result.left.val);
        //System.out.println(result.right.val);
    }
    return result;
  }
  private TreeNode buildSmallTree(char operator, int a, int b){
    TreeNode root = new TreeNode(0,operator);
    TreeNode left = new TreeNode(a,'\0');
    TreeNode right = new TreeNode(b,'\0');
    root.left = left;
    root.right = right;
    return root;
  }
}

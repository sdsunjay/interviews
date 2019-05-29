/**
 * Write a function that determines whether the left or right branch of the tree is larger.
 * The size of each branch is the sum of the node values.
 * The function should return the string "right" if the right side is larger and "left" if the left side is larger
 *
 */
class Solution {
    // Node
    static class Node {
        long data;
        Node left, right;
        Node(long data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static String solution(long[] arr) {
       if(arr.length == 0){
           return "";
       }
       long left, right;
       Node root = new Node(arr[0]);
       root = buildTree(arr, root, 0);
       left = getSum(root.left, root.data);
       right = getSum(root.right, root.data);

       if(left > right){
           return "Left";
       }
       else if(right > left){
           return "Right";
       }
       return "";
    }
    public static Node buildTree(long[] arr, Node root, int i){
      if(i < arr.length) {
          if(arr[i] != -1){
              Node temp = new Node(arr[i]);
              root = temp;
              root.left = buildTree(arr, root.left, 2 * i + 1);
              root.right = buildTree(arr, root.right, 2 * i + 2);
          }
      }
      return root;

    }
    public static long getSum(Node root, long sum){
      if(root == null){
          return 0;
      }
      if(root.left == null && root.right == null){
          return root.data;
      }
      return root.data + getSum(root.left, sum) + getSum(root.right, sum);
    }
}



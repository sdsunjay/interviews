import java.util.*;
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
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  private int sumArray(int[] intArray, int length){
    int num1 = intArray[0];
    for(int i = 1; i < length; i++) {
      num1 = num1*10 + intArray[i];
    }
    return num1;

  }

  public int sumNumbers(TreeNode root) {
    int sum = 0;
    if(root == null){
      return sum;
    }

    int i = 0;
    int intArray[];    //declaring array
    intArray = new int[10];  // allocating memory to array
    LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
    linkedList.add(root);
    HashSet<TreeNode> hashSet = new HashSet<>();
    while(!linkedList.isEmpty()){
      TreeNode temp = linkedList.peek();
      intArray[i] = temp.val;
      i++;
      if(temp.right == null && temp.left == null){
        sum+=sumArray(intArray, i);
        linkedList.pop();
        i--;
      }
      else {
        if(hashSet.contains(temp)){
          linkedList.pop();
          i--;
          i--;
        }
        else {
          if (temp.right != null){
            linkedList.push(temp.right);
          }
          if (temp.left != null){
            linkedList.push(temp.left);
          }
          hashSet.add(temp);
        }
      }
    }
    return sum;
  }
}

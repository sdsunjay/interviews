// https://leetcode.com/problems/cousins-in-binary-tree/submissions/
class Solution {

  public static void main(String args[]) {
    Node[] temp = new Node[9];
    temp[0] = new Node(2);
    temp[1] = new Node(3);
    temp[2] = new Node(4);
    temp[3] = new Node(5);
    temp[4] = new Node(6);
    temp[5] = new Node(7);
    temp[6] = new Node(8);
    temp[7] = new Node(9);
    temp[8] = new Node(10);
    /**
		* 			2
		* 		/		\
		* 	3				4
	  *	 / \		/		\
		* 5	  6	 7			8
    *   /            \
		*  9              10
    */

    Node.buildTree(temp);
    BinaryTree tree = new BinaryTree();
    tree.root = temp[0];
    System.out.println("Expected Output: True");
    System.out.println("Output: " + tree.isCousins(tree.root, 9, 10));
    System.out.println("Expected Output: False");
    System.out.println("Output: " + tree.isCousins(tree.root, 5, 6));
    System.out.println("Expected Output: False");
    System.out.println("Output: " + tree.isCousins(tree.root, 5, 9));
    System.out.println("Expected Output: False");
    System.out.println("Output: " + tree.isCousins(tree.root, 2, 8));
    System.out.println("Expected Output: True");
    System.out.println("Output: " + tree.isCousins(tree.root, 5, 7));
    System.out.println("Expected Output: True");
    System.out.println("Output: " + tree.isCousins(tree.root, 6, 7));
  }
  //[1,2,3,null,4,null,5]
//5
//4
}

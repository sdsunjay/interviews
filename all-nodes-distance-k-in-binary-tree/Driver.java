public class Driver {

  public static void main(String args[]) {
    TreeNode[] temp = new TreeNode[9];
    temp[0] = new TreeNode(2);
    temp[1] = new TreeNode(3);
    temp[2] = new TreeNode(4);
    temp[3] = new TreeNode(5);
    temp[4] = new TreeNode(6);
    temp[5] = new TreeNode(7);
    temp[6] = new TreeNode(8);
    temp[7] = new TreeNode(9);
    temp[8] = new TreeNode(10);
    /**
		* 			2
		* 		/		\
		* 	3				4
	  *	 / \		/		\
		* 5	  6	 7			8
    *   /   \
		*  9     10
    */

    TreeNode.buildTree(temp);
    Solution tree = new Solution();
    System.out.println(tree.distanceK(temp[0], temp[1], 2).toString());
    temp = new TreeNode[9];
    temp[0] = new TreeNode(3);
    temp[1] = new TreeNode(5);
    temp[2] = new TreeNode(1);
    temp[3] = new TreeNode(6);
    temp[4] = new TreeNode(2);
    temp[5] = new TreeNode(0);
    temp[6] = new TreeNode(8);
    temp[7] = new TreeNode(7);
    temp[8] = new TreeNode(4);
    /**
		* 			2
		* 		/		\
		* 	5				1
	  *	 / \		/		\
		* 6	  2	 0			8
    *   /   \
		*  7     4
    */
    TreeNode.buildTree(temp);
    System.out.println(tree.distanceK(temp[0], temp[1], 2).toString());
    System.out.println(tree.distanceK(temp[0], temp[1], 3).toString());
    System.out.println(tree.distanceK(temp[0], temp[1], 0).toString());
    System.out.println(tree.distanceK(null, temp[1], 2).toString());
    System.out.println(tree.distanceK(null, null, 2).toString());
  }
}

private static int isPresent(Node root, int val){
/* For your reference
class Node {
		Node left, right;
		int data;
                Node(int newData) {
			left = right = null;
			data = newData;
		}
	}
*/
    Node temp;
    Queue<Node> queue = new LinkedList<Node>();
    if(root == null){
      return 0;
    }
    queue.offer(root);
    while (!queue.isEmpty()) {
        temp = queue.poll();
        if(temp == null){
          return 0;
        }
        if(val == temp.data){
            return 1;
        }
        if(val < temp.data){
            // go left
            queue.offer(temp.left);
        }
        else{
            // go right
            queue.offer(temp.right);
        }
    }
    return 0;
}

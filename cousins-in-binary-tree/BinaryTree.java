import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree{
  Node root;

  public BinaryTree() {
    root = null;
  }
  // find depth of x and y, see if they match
  // find parent of x and y, see if they don't match
  public boolean isCousins(Node root, int x, int y) {
    return traverse(root, x, y);
  }
  private boolean traverse(Node root, int x, int y) {
    Queue<Node> queue = new LinkedList<Node>();
    if(root == null){
      return false;
    }
    queue.offer(root);
    Node temp;
    int size = 0;
    int depthX, depthY;
    while(!queue.isEmpty()) {
      depthX = -1;
      depthY = -1;
      size = queue.size();
      for(int i = 0 ; i < size; i++){
        temp = queue.poll();
        if(temp == null){
          continue;
        }
        if(temp.value == x){
          depthX = i;
          // System.out.println("We found: " + x);
          // we found the node
        }
        else if(temp.value == y){
          depthY = i;
          // System.out.println("We found: " + y);
          // we found the node
        }
        //System.out.println(temp.value);
        queue.offer(temp.left);
        queue.offer(temp.right);

      }
      if(depthX != -1 || depthY != -1){
        return handleDepth(depthX, depthY);
      }
    }
  // neither are ever found
    return false;
  }
  private boolean handleDepth(int depthX, int depthY){
  // they have the same parent, so their value is only off by 1
  if(depthX % 2 == 0 && depthY == depthX+1){
    return false;
  }
  // they have the same parent, so their value is only off by 1
  if(depthY % 2 == 0 && depthX == depthY+1){
    return false;
  }
  // their value is off by more than 1
  // both have been found
  if(depthX != -1 && depthY != -1){
    return true;
  }
  // only one was found
  return false;

  }
}

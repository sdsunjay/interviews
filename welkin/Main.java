// Class name must be "Main"
// Libraries included:
// json simple, guava, apache commons lang3, junit, jmock
// print a tree in level order
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
class Main {
  public static void main(String[] args) {
    Node root = new Node(3);
    root.left = new Node(9);
    root.right = new Node(20);
    root.right.left = new Node(15);
    root.right.right = new Node(7);
    levelOrder(root);
  }
  public static class Node {
    Integer value;
    Node left;
    Node right;
    public Node(int x) { value = Integer.valueOf(x); }
    public String toString(){
      return value.toString();
    }
  }
  public static void levelOrder(Node root){
    LinkedList<Node> queue = new LinkedList<Node>();
    if(root == null){
			return;
    }
    queue.add(root);
    Node temp;
    ArrayList<ArrayList<Node>> bigList = new ArrayList<ArrayList<Node>>();
    ArrayList<Node> myList;
    while(!queue.isEmpty()){
      myList = new ArrayList<Node>();

      for(int i= 0; i< queue.size();i++){
        temp = queue.remove();
        // this isn't right, fully

        myList.add(temp);

        if(temp.left != null){
          queue.add(temp.left);
        }
        if(temp.right != null){
          queue.add(temp.right);
        }
        // original
        // this does not feel right
        // bigList.add(myList);

			  if(myList.size() != 0){
				  bigList.add(myList);
			  }
      }
    }

    int i = 0;
    int j = 0;
    for(i=0; i < bigList.size(); i++){
      myList = bigList.get(i);
      System.out.println(myList.toString());
        // for(j= 0; j<myList.size();j++){
      //  System.out.print(myList.get(j).value + ' ');
      // }
      System.out.println('\n');
    }
  }
}

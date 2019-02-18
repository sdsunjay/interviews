import java.util.Queue;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
public class Node{

  Node left;
  Node right;
  int value;
  boolean discovered;
  public Node(int value) {
    left = null;
    right = null;
    this.value = value;
    discovered = false;
  }
  public Node(Node left, Node right, int value) {
    this.left = left;
    this.right = right;
    this.value = value;
    this.discovered  = false;

  }
  private void setLeft(Node left) {
    this.left = left;
  }
  private void setRight(Node right) {
    this.right = right;
  }
  public static Node buildTree(Node[] temp) {

    temp[0].setLeft(temp[1]);
    temp[0].setRight(temp[2]);

    temp[1].setLeft(temp[3]);
    temp[1].setRight(temp[4]);

    temp[2].setLeft(temp[5]);
    temp[2].setRight(temp[6]);

    temp[4].setLeft(temp[7]);
    temp[6].setRight(temp[8]);
    return temp[0];
  }
}

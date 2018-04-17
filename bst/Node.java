import java.util.Arrays;
import java.lang.Integer;
public class Node {
    public Node left, right;
    public int data;

    public Node(int data){
        this.data = data;
    }

    /**
     * Insert a new node of value @param value.
     * @param value - the value of what we want to insert.
     */
    public void insert(int value){
        if(value <= data){
            if(left == null){
                left = new Node(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null){
                right = new Node(value);
            } else {
                right.insert(value);
            }
        }
    }

    public boolean contains(int value){
        if(value == data){
            return true;
        } else if (value < data){
            if(left == null){
                return false;
            } else {
                left.contains(value);
            }
        } else {
            if (right == null){
                return false;
            } else {
                right.contains(value);
            }
        }
        return false;
    }

    public void printInOrder(){
        if (left != null){
            left.printInOrder();
        }
        System.out.println(data);
        if (right != null) {
            right.printInOrder();
        }
    }
    private Node[] dfs(Node root){
    // we need to use a isVisited flag

    }
    private Node[] bfs(Node root){
    // use a queue
    }
    private boolean isBST(Node n, int min, int max){
        if (n == null)
            return true;
        if (n.data < min || n.data > max)
            return false;
        return isBST(n.left, min, n.data) && isBST(n.right, n.data, max);

    }
    /**
     * Determine if the tree is a valid Binary Search Tree
     * @param root - the root of the tree
     * @return True - if the tree is a valid BST
     */
    public boolean isBST(Node root){
        // runtime is O(n)
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static void balance(Node root){
        // build ordered array using dfs
        // get middle element of the array and make it the root
        // same for elements to the left
        // same for elements to the right

        // my thought process
        // add left and right to a queue
        // if left is smaller than me, make me the right child
        // if left is larger than me, make them the right child
        // if right is larger than me, make them the right child
        // add myself to stack
        // add left to stack
        // add right to stack
        // 10 20 30
        // dfs adding to stack
    }
}

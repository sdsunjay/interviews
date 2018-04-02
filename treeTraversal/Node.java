public class Node{

    Node left;
    Node right;
    int value;
    boolean discovered;
    public Node(int value)
    {
        left = null;
        right = null;
        this.value = value;
        discovered = false;
    }
    public Node(Node left, Node right, int value)
    {
        this.left = left;
        this.right = right;
        this.value = value;
        this.discovered  = false;

    }
    public boolean isDiscovered()
    {
        return discovered;
    }
    private void setLeft(Node left)
    {
        this.left = left;
    }
    private void setRight(Node right)
    {
        this.right = right;
    }
    public void outputTree()
    {
        System.out.print("\t \t \t" + value);
        System.out.println();
        System.out.print("\t " + left.value);
        System.out.print("\t \t \t \t" + right.value);
        System.out.println();
        System.out.print(left.left.value);
        System.out.print("\t \t"+left.right.value);
        System.out.print("    \t \t" +right.left.value);
        System.out.print("\t \t \t  "+right.right.value);
        System.out.println();
    }
    public static Node buildTree(Node[] temp)
    {
       
        temp[0].setLeft(temp[1]);
        temp[0].setRight(temp[2]);
        
        temp[1].setLeft(temp[3]);
        temp[1].setRight(temp[4]);
        
        temp[2].setLeft(temp[5]);
        temp[2].setRight(temp[6]);
        
     //   temp[4].setRight(temp[7]);
        return temp[0]; 
    }
}

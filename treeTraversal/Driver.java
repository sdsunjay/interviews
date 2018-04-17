public class Driver
{	
	public static void main(String args[])
	{
        Node[] temp = new Node[8];
        temp[0] = new Node(2);
        temp[1] = new Node(3);
        temp[2] = new Node(4);
        temp[3] = new Node(5);
        temp[4] = new Node(6);
        temp[5] = new Node(7);
        temp[6] = new Node(8);
        temp[7] = new Node(9);
        Node root;
        root = Node.buildTree(temp);
        root.outputTree();
       	System.out.println("Depth first search");
        System.out.println("Expected: 2, 3, 5, 6, 4, 7, 8");	
        Dfs dfs = new Dfs(root);
	    dfs.traverse();	
        temp[0] = new Node(2);
        temp[1] = new Node(3);
        temp[2] = new Node(4);
        temp[3] = new Node(5);
        temp[4] = new Node(6);
        temp[5] = new Node(7);
        temp[6] = new Node(8);
        temp[7] = new Node(9);
        root = Node.buildTree(temp);
        root = Node.buildTree(temp); 
       	System.out.println("Breath first search");
        System.out.println("Expected: 2, 3, 4, 5, 6, 7, 8");	
        Bfs bfs = new Bfs(root);
	    bfs.traverse();	
	} 
}

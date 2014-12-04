public class Driver
{	
	public static void main(String args[])
	{
	Node root;
	System.out.println("Expected: 5, 3, 2, 4, 6");	
	Node temp2 = new Node(null,null,2,false);
	Node temp3 = new Node(null,null,4,false);
	Node temp = new Node(temp2,temp3,3,false);
	Node temp1 = new Node(null,null,6,false);

	root = new Node(temp, temp1, 5, false);
	System.out.println("    5\n 3    6\n2  4");  
       	Dfs dfs = new Dfs(root);
	dfs.traverse();	
	} 
}

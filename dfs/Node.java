
	public class Node{

		Node left;
		Node right;
		int value;
		boolean discovered;
		public Node(Node left, Node right, int value, boolean discovered)
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
	}

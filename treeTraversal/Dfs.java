import java.util.*;
public class Dfs{

	Node root;

	public Dfs(Node root)
	{
		this.root = root;

	}
	public void traverse()
	{

		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.isEmpty())
		{
			Node temp;
			temp = stack.pop();
			System.out.println(temp.value);
			if(!temp.isDiscovered())
			{
				temp.discovered = true;
			}
			if(temp.right != null)
			{
				stack.push(temp.right);
			}
			if(temp.left != null)
			{
				stack.push(temp.left);
			}
		}
	}

}

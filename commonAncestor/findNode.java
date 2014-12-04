import java.util.*;
public class findNode implements FirstCommonAncestor{

	public Node commonAncestor(Node one, Node two)
	{
		Node temp = one.parent;
		Node prev = one;
		//check if temp is null
		if(temp==null)
			return one;
		if(one.right != null && one.right.equals(two))
		{
			return one;
		} 
		else if(one.left != null && one.left.equals(two))
		{
			return one;
		} 
		else if(two.right != null && two.right.equals(one))
		{
			return two;
		} 

		if(two.left != null && two.left.equals(one))
		{
			return two;
		} 
		
		
		
		
		while(!temp.isRoot())
		{
			//use previous
			if(temp.left.equals(prev))
			{
				if(checkTree(temp.right,two))
				{
					return temp;
				}
			}
			else
			{
				if(checkTree(temp.left,two))
				{
					return temp;
				}
			}
			prev = temp;  
			temp = temp.parent;
		}	
		return temp;
	}
	public boolean checkTree(Node origin,Node dest)
	{

		if(origin == null)
		{
			return false;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.push(origin);
		Node temp;
		while(!stack.isEmpty())
		{
			temp = stack.pop();
			if(temp.equals(dest))
			{
				return true;
			}  
			if(temp.right!=null)
			{
				stack.push(temp.right);
			}
			if(temp.left!=null)
			{
				stack.push(temp.left);
			}
		}
		return false;

	}

}

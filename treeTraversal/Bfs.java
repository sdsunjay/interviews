import java.util.*;
public class Bfs{

	Node root;

	public Bfs(Node root)
	{
		this.root = root;

	}
	public void traverse()
	{
        //Since queue is a interface
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            Node temp;
            temp = queue.remove();
			temp.discovered = true;
            System.out.println(temp.value);
			if(temp.left != null)
			{
			    if(temp.left.discovered == false)
				    queue.add(temp.left);
			}

			if(temp.right != null)
			{
			    
			    if(temp.right.discovered == false)
				    queue.add(temp.right);
			}
        }
    }
}

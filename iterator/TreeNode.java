// Google Interview Question
import java.util.*;

class TreeNode<T> implements Iterable<T> {
	private T value;
	private List<TreeNode<T>> children;


	public TreeNode() {

		children = new ArrayList<TreeNode<T>>();

	}

	public boolean hasChildren()
	{
		return !children.isEmpty();
	}
	public TreeNode getChildren(int index)
	{
		return children.get(index);
	}
	public void setValue(T value)
	{
		this.value = value;
	}
	public void addToChildren(TreeNode<T> value)
	{
		children.add(value);
	
	}

	public Iterator<T> iterator() {

		return new Iterator<T>() {

			int nextCounter = 0;
			int anotherCounter = 0;
			Iterator childIterator;
			//Since queue is a interface
			Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
			
			@Override
			public T next()
			{
				TreeNode<T> temp;
				T returnMe = null;
				if(value != null)
				{
				
					returnMe = value;
					value = null;
					return returnMe;
				}
				else if(children.get(nextCounter).hasChildren())
				{
					queue.add(children.get(nextCounter));
				}
				if(!queue.isEmpty() &&  nextCounter >= children.size())
				{
					anotherCounter = 0;
					//only remove if we have through the children
					temp =  queue.remove();
					return temp.children.get(0).iterator().next();
				}
				return children.get(nextCounter++).iterator().next();
			//if child has children, keep track of index, go there
	//			if(queue.isEmpty())
	//			{
	//				return children.get(nextCounter++).iterator().next();
	//			}
			//	else
		//		{
			}

			@Override
			public boolean hasNext()
			{
				return nextCounter < children.size() && queue.isEmpty();
			}
			@Override
			public void remove() {
					// TODO Auto-generated method stub
		        }

		};
	}
}

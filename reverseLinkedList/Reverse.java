public class Reverse
{
	Node head;
	public Reverse(Node head)
	{
		this.head = head;
	}
	public void reverseList()
	{
		if(head!=null)
			helper(head);
	}
	public void helper(Node node)
	{
		//recursive case
		if(node.next.next!=null)
		{
			helper(node.next);
		
			node.next.next = node;
			node.next = null; //set "old" next pointer to NULL
		}
		//base case
		else
		{
			head = node.next;	
			head.next = node;
			return;
		}
		return;
		//return node.next;

	}
}

public class Driver
{
	public static void main(String[] arg)
	{
		Node node1 = new Node(0);
		Node node2 = new Node(1);
		Node node3 = new Node(2);
		node1.next = node2;
		node2.next = node3;
		node3.next = null;
		Node trav = node1;
		System.out.println("Original: ");
		while(trav!=null)
		{
			System.out.print(trav+" - > ");
			trav=trav.next;
		}
		System.out.println("");
		System.out.println("Reversed: ");
		Reverse reverseMe = new Reverse(node1);	
		reverseMe.reverseList();
		trav = reverseMe.head;
	
		while(trav!=null)
		{
			System.out.print(trav+ " - > ");
			trav=trav.next;
		}
		System.out.println("");
}

}

public class Driver
{
	public static void main(String[] args)
	{
		findNode fN = new findNode();
		Node F = new Node('F',null,null,null);
		Node G = new Node('G',null,null,null);
		Node E = new Node('E', null,G,F);
		F.setParent(E);
		G.setParent(E);
		Node D = new Node('D',null,null,null);
		Node B = new Node('B',null,D,E);
		D.setParent(B);
		E.setParent(B);
		Node C = new Node('C',null,null,null);
		Node A = new Node('A',null,B,C);
		C.setParent(A);
		B.setParent(A);
		//A.printTree();
	        System.out.println("     A\n  B   C\nD  E\n  G  F\n");   	
		System.out.println("Who is D and F's lowest common ancestor?");
		System.out.println("Expected: B");
		System.out.println(fN.commonAncestor(D,F)); 
		System.out.println("Who is C and G's lowest common ancestor?");
		System.out.println("Expected: A");
		System.out.println(fN.commonAncestor(C,G)); 
		System.out.println("Who is E and B's lowest common ancestor?");
		System.out.println("Expected: B");
		System.out.println(fN.commonAncestor(E,B)); 
	}
}

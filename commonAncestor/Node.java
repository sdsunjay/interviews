class Node {

	Node parent;
	Node left;
	Node right;
	char A;
  int val;

	public Node(char A, Node parent, Node left, Node right, int val) {
		this.A = A;
    this.val = val;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}

	public boolean isRoot() {
		return parent == null;
	}
	public void setParent(Node parent)
	{
		this.parent = parent;
	}
	public boolean equals(Node other)
	{
		return A == other.A;
	}
	public String toString()
	{
		Character temp = new Character(A);
		return temp.toString();
	}
	public void printTree()
	{
		System.out.println(A);
		if(left!=null)
		{
			System.out.print(left);
			left.printTree();
		}
		else
			System.out.print("  ");

		if(right!=null)
		{
			System.out.print(right);
			right.printTree();
		}
		else
			System.out.print("  ");

	}
  public Node commonAncestor(Node root, Node p, Node q){
    if(p.val < root.val && q.val < root.val){
      return commonAncestor(root.left, p, q);
    }
    else if(p.val > root.val && q.val > root.val){
      return commonAncestor(root.right, p, q);
    }
    return root;
  }


}


// Google Interview Question
import java.util.*;
/*
   4
   /|\
   3 1 5
   |\
   2 9  
   */
public class Driver{

	public static void main(String args[])
	{
		TreeNode root;
		TreeNode temp;
		TreeNode temp1;
		TreeNode temp2;
		TreeNode temp3;
		TreeNode temp4;
		TreeNode temp5;
		root = new TreeNode<Integer>();
		temp = new TreeNode<Integer>();
		root.setValue(new Integer(4));
		temp = new TreeNode<Integer>();
		temp.setValue(new Integer(3));
		root.addToChildren(temp);
		temp1 = new TreeNode<Integer>();
		temp1.setValue(new Integer(1));
		root.addToChildren(temp1);
		temp2 = new TreeNode<Integer>();
		temp2.setValue(new Integer(5));
		root.addToChildren(temp2);
		temp3 = new TreeNode<Integer>();
		temp3.setValue(new Integer(2));
		root.getChildren(1).addToChildren(temp3);
		temp4 = new TreeNode<Integer>();
		temp4.setValue(new Integer(9));
		root.getChildren(1).addToChildren(temp4);
		Iterator<TreeNode<Integer>> it = root.iterator();
		System.out.println("Expected: 4,3,1,5,2,9");
		while (it.hasNext()){
			System.out.println(it.next());
		}

		System.out.println("Expected: An Exception was thrown");
		//test exception throw
		try
		{	
			
			System.out.println(it.next());
		}
		catch(Exception e)
		{
			System.out.println("An Exception was thrown");
		}

	}

}

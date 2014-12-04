
import java.util.*;

public class Driver{

	public static void main(String args[])
	{
/*
false false true false false
true true false true true
true false true true true
false false false false false
*/
//matrix[rows][columns]
	System.out.println("false false true false false"+"\n"+"true true false true true"+"\n"+"true false true true true"+"\n"+"false false false false false");

	boolean[][] matrix = new boolean[4][5];
	matrix[0][0] = false;
	matrix[0][1] = false;
	matrix[0][2] = true;
	matrix[0][3] = false;
	matrix[0][4] = false;
	
	matrix[1][0] = true;
	matrix[1][1] = true;
	matrix[1][2] = false;
	matrix[1][3] = true;
	matrix[1][4] = true;

	matrix[2][0] = true;
	matrix[2][1] = false;
	matrix[2][2] = true;
	matrix[2][3] = true;
	matrix[2][4] = true;
	
	matrix[3][0] = false;
	matrix[3][1] = false;
	matrix[3][2] = false;
	matrix[3][3] = false;
	matrix[3][4] = false;
	

	FindNode findNode = new FindNode();
	System.out.println(findNode.findTrue(matrix));

	//System.out.println("Expected: 4,3,1,5,2,9");
	//System.out.println("Expected: An Exception was thrown");
	}

}

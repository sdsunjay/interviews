import java.util.*;
public class FindNode
{
	final int ROWS = 4;


	public String findTrue(boolean[][] matrix)
	{
		int count  = 0;
		int tempHigh =0;
		ArrayList<Node> tracker = new ArrayList<Node>();

		Node temp;

		for(int i = 0; i < ROWS ; i++)
		{
			for(int j = 0 ; j < matrix[i].length ; j ++ )
			{
				if(matrix[i][j])
				{
					tempHigh = CountThem(matrix, i,j);
					if (tempHigh > count)
					{
						count = tempHigh;
						tracker.add(new Node(i,j,count));
						System.out.println("Highest Count so far is: "+count);
					}
				}
			}

		}
		temp=findNode(tracker,count);
		return temp.toString();
		//this probably won't work since original matrix has been altered
		//fill ret 
	}
	private Node findNode(ArrayList<Node> tracker,int count)
	{
		for(int i = 0; i< tracker.size(); i++)
		{
			if(tracker.get(i).counter == count)
			{
				return tracker.get(i);
			}
		}
		return null;
	}
	private class Node
	{
		public int i;
		public int j;
		public int counter;
		public Node(int i,int j)
		{
			this.i = i;
			this.j = j;
			counter = 0;
		}
		public Node(int i,int j, int counter)
		{
			this.i = i;
			this.j = j;
			this.counter = counter;
		}
		public String toString()
		{
			return "(column: "+i+", row:"+j+", count: "+counter+") ";
		}

	}
	//check left, right and down
	//we must mark them somehow
	//we need to use a queue
	private int CountThem(boolean[][] matrix,int i, int j)
	{
		//count of trues
		int counter = 0;
		//Since queue is a interface
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(i,j));
		Node temp;
		//System.out.println("Length of row: "+ matrix[i].length);
		while(!queue.isEmpty())
		{
			temp=queue.remove();
			//System.out.println("Checking matrix["+temp.i+"]"+"["+temp.j+"]");
			//check left
			if( (temp.j != 0) && ( matrix[temp.i][temp.j-1]))
			{
				counter++;
				//we’ve counted it, now make it false so we don’t recount
				matrix[temp.i][temp.j-1] = false;
				queue.add(new Node(temp.i,temp.j-1));
			}
			//check right
			if( (temp.j+1 < matrix[temp.i].length) && (matrix[temp.i][temp.j+1]))
			{
				counter++;
				//we’ve counted it, now make it false so we don’t recount
				matrix[temp.i][temp.j+1] = false;
				queue.add(new Node(temp.i,temp.j+1));

			}
			//check down
			if( (temp.i+1 < ROWS &&  matrix[temp.i+1][temp.j]))
			{
				counter++;
				//we’ve counted it, now make it false so we don’t recount
				matrix[temp.i+1][temp.j] = false;
				queue.add(new Node(temp.i+1,temp.j));
			}
		}//close while
		if(counter == 0)
			return 1;			
		return counter;

	}
}

import java.util.*;
import java.io.*;

class Node {
	int data;
	List<Node> children;

	public Node(int data) {
		this.data = data;
		this.children = new ArrayList<Node>();
	}
}

public class Solution {


    public static void printZigZag(Node root) {
        /*
        Print the levels of a n-ary tree in a zig-zag pattern
        Keyword Arguments:
        root -- Node object representing the root of an n-ary tree
        Example:
                           1
                         / | \
                        2  3  4
                      /  \ |  |
                     5   6 7  8
                   / | \   |  | \
                  9  10 11 12 13 14
        Expected result:
        1
        4 3 2
        5 6 7 8
        14 13 12 11 10 9
        */
        // BFS
        // queue - fifo
        Queue<Node> queue = new LinkedList<Node>();
        if(root == null){
            return;
        }
        queue.add(root);
        ArrayList<Node> level = new ArrayList<Node>();
        Node temp;
        boolean left = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            //System.out.println("Size: " + size);
            while(size > 0){
                temp = queue.remove();
                level.add(temp);
                //System.out.print(temp.data + " ");
                for(int i=0; i <  temp.children.size(); i++){
                    queue.add(temp.children.get(i));
                    // System.out.println("CHILD ADDED: " + temp.children.get(i).data);
                }
                size--;
            }
            // all the printing
            if(left){
                for(int i = 0; i< level.size(); i++){
                    System.out.print(level.get(i).data + " ");
                }
                left = false;
            }
             else{
                for(int i = level.size()-1; i >= 0 ; i--){
                    System.out.print(level.get(i).data + " ");
                }
                left = true;
            }
            level = new ArrayList<Node>();

            System.out.println("");
        }
    }

    public static Node constructTree() throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		if(n==0) return null;
		Map<Integer, Node> map = new HashMap<Integer, Node>(n);

		String line = null;

		while((line=in.readLine())!=null) {
			String[] splitArray = line.split("\\s+");
			int parentVal = Integer.parseInt(splitArray[0]);
			Node parent = getOrCreateNode(map, parentVal);

			for(int i=1; i<splitArray.length; i++) {
				int childVal = Integer.parseInt(splitArray[i]);
				Node child = getOrCreateNode(map, childVal);
				parent.children.add(child);
			}

		}

		return map.get(1);
	}

	private static Node getOrCreateNode(Map<Integer, Node> map, int val) {
		if(map.containsKey(val)) {
			return map.get(val);
		}
		Node node = new Node(val);
		map.put(val, node);
		return node;
	}

	public static void main(String[] args) {
		try {
			Node root = constructTree();
			printZigZag(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.AbstractList;
import java.util.*;
/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public List<List<Integer>> levelOrder(TreeNode root) {

		if(root == null){
			return new ArrayList<>();
		}
		//BFS
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		return bfs(queue);
	}
	private List<List<Integer>> bfs(LinkedList<TreeNode> queue){
		List<List<Integer>> bigList = new ArrayList<List<Integer>>();
		List<Integer> smallList;

		while(!queue.isEmpty())
		{
			smallList = new ArrayList<Integer>();
			int layerSize = queue.size();

			// we need this because we need to know whether
			// there is one item in this layer or two
			for (int i = 0; i < layerSize; i++) {
				TreeNode temp = queue.remove();
				smallList.add(new Integer(temp.val));
				if(temp.left != null){
					queue.add(temp.left);
				}
				if(temp.right != null){
					queue.add(temp.right);
				}
			}
			if(smallList.size() != 0){
				bigList.add(smallList);
			}
		}
		return bigList;
	}
}

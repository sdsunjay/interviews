// https://leetcode.com/problems/minimum-height-trees/description/
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.Integer;
class Solution {

    private class Node{
        public ArrayList<Node> children;
        int value;
        boolean visited = false;
        public Node(int value){
            this.value = value;
        }
        public String toString(){
            return Integer.toString(value);
        }
    }

    public class Tree{
        public Node root;
    }

    public int findHeight(Node root) {
        for(int i = 0; i < root.children.size(); i++){
            return 1 + findHeight(root.children.get(i));
        }
        return 0;
    }

    private ArrayList<Node> getChildren(Node temp, int[][] edges){
        ArrayList<Node> children = new ArrayList<Node>(edges.length);
        for(int i = 0; i < edges.length; i++){
            if (edges[i][0] == temp.value)
                children.add(new Node(edges[i][1]));
            else if (edges[i][1] == temp.value)
                children.add(new Node(edges[i][0]));

        }
        return children;
    }
    public ArrayList<Integer> buildListOfRoots(int n, int[][] edges){
        ArrayList<Integer> roots = new ArrayList<Integer>(edges.length);
        for(int i = 0; i < edges.length; i++){
            if (!roots.contains(edges[i][0]))
                roots.add(edges[i][0]);
            if (!roots.contains(edges[i][1]))
                roots.add(edges[i][1]);
        }
        return roots;
    }

    public Node buildTree(Integer root, int[][] edges){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(root));
        Node temp = null;
        while(queue.isEmpty() == false){
            System.out.println(temp);
            temp = queue.poll();
            temp.children = getChildren(temp, edges);
            System.out.println("Children: " + temp.children);
            // add all the children to the queue
            for(int i = 0; i < temp.children.size(); i++){
                queue.add(temp.children.get(i));
            }

        }
        return new Node(root);
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer> roots = buildListOfRoots(n, edges);
        ArrayList<Node> nodeRoots = new ArrayList<Node>(edges.length);
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int height = n;
        int minHeight = n;
        for (Integer root : roots) {
            System.out.println(root);
            nodeRoots.add(buildTree(root, edges));
        }
        minHeight = n;
        for(Node root: nodeRoots) {
             height = findHeight(root);
             if(height < minHeight){
                 //answer.removeAll();
                 answer.add(root.value);
             }
             if(height == minHeight){
                answer.add(root.value);
             }

        }
        return answer;
    }
}

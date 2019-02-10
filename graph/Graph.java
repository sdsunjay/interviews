import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;
public class Graph {
  private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

  public static class Node {
    private int id;
    LinkedList<Node> adjacent = new LinkedList<Node>();

    private Node(int id){
      this.id = id;
    }
  }
  private Node getNode(int id){
    return nodeLookup.get(new Integer(id));
  }
  public void addEdge(int source, int destination){
    Node s = getNode(source);
    Node d = getNode(destination);
    s.adjacent.add(d);
  }
  public boolean hasPathDFS(int source, int destination){
    Node s = getNode(source);
    Node d = getNode(destination);
    HashSet<Integer> visited = new HashSet<Integer>();

    if(s == null)
      return false;
    if(d == null)
      return false;
    return hasPathDFS(s, d, visited);
  }
  private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited){
    if(visited.contains(source.id)){
      return false;
    }
    visited.add(source.id);
    if(source.id == destination.id){
      return true;
    }
    for(Node child : source.adjacent){
      if (hasPathDFS(child, destination, visited)){
        return true;
      }
    }
    return false;
  }
  public boolean hasPathBFS(int source, int destination){
    return hasPathBFS(getNode(source), getNode(destination));
  }
  private boolean hasPathBFS(Node source, Node destination){
    LinkedList<Node> nextToVisit = new LinkedList<Node>();
    HashSet<Integer> visited = new HashSet<Integer>();
    if(source == null)
      return false;
    if(destination == null)
      return false;
    nextToVisit.add(source);
    while(!nextToVisit.isEmpty()){
      Node current = nextToVisit.remove();

      if(current.id == destination.id){
        return true;
      }
      visited.add(current.id);

      for(Node child : current.adjacent){
        nextToVisit.add(child);
      }
    }
    return false;
  }
}

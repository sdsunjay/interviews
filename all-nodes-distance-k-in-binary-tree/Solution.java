// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

class Solution {

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

    HashMap<TreeNode, TreeNode> parents = new HashMap<TreeNode, TreeNode>();
    HashSet<TreeNode> seen = new HashSet<TreeNode>();
    Queue<TreeNode> q = new LinkedList<>();
    if(root != null){
      q.add(root);
      parents.put(root, null);
    }
    TreeNode temp;
    while(!q.isEmpty()){
      temp = q.remove();

      if(temp.left != null){
        q.add(temp.left);
        if(!parents.containsKey(temp.left)){
          parents.put(temp.left, temp);
        }
      }
      if(temp.right != null){
        q.add(temp.right);
        if(!parents.containsKey(temp.right)){
          parents.put(temp.right, temp);
        }
      }
    }
    q = new LinkedList<>();
    if(target != null){
      q.add(target);
    }
    int level = 0;
    int size;
    TreeNode parent;
    while(!q.isEmpty()){

      if(level == K){
        break;
      }
      size = q.size();
      for(int i = 0 ; i < size; i++){
        temp = q.remove();
        if(!seen.contains(temp)){
          seen.add(temp);
        }
        parent = parents.get(temp);
        // we need to check if we have already parents this one
        if(parent != null){
          if(!seen.contains(parent)){
            q.add(parent);
          }
        }
        if(temp.left != null){
          if(!seen.contains(temp.left)){
            q.add(temp.left);
          }
        }
        if(temp.right != null){
          if(!seen.contains(temp.right)){
            q.add(temp.right);
          }
        }
      }
      level++;
    }
    List<Integer> arrayList = new ArrayList<Integer>();
    for (TreeNode node: q) {
      arrayList.add(node.val);
    }
    return arrayList;
  }
}

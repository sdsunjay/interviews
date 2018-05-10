import java.util.ArrayList;
import java.util.LinkedList;

// https://leetcode.com/problems/bus-routes/description/
public class Solution {
	public ArrayList<Bus> allBuses = null;

	public int numBusesToDestination(int[][] routes, int S, int T) {
		int ret = -1;
        int temp = 0;
		allBuses = new ArrayList<Bus>(routes.length);
        setAllBuses(routes);
		// S can occur in more than one bus route
		ArrayList<Bus> s = findBusS(allBuses, S);
		//System.out.println("Root: " + s);
		for(int i = 0; i < s.size(); i++){
		    System.out.println("Root: " + s.get(i));
            allBuses.remove(s.get(i));
            temp = bfs(s.get(i), T, allBuses);
		    System.out.println("temp: " + temp);
            if(temp > -1){
                if(ret != -1){
                    if(temp < ret)
                        ret = temp;
                } else {
                        ret = temp;
                }
            }
		    allBuses.add(s.get(i));
            resetDepth();
        }

		System.out.println(ret);
		return ret;
	}
    private int bfs(Bus node, int T, ArrayList<Bus> allBuses){
 		Bus temp = null;
		int depth = 0;

		// Create a queue for BFS
        LinkedList<Bus> queue = new LinkedList<Bus>();
        // Mark the current node as visited and enqueue it
        queue.add(node);
        while (queue.size() != 0){
			temp = queue.poll();
            if(temp.isVisited() == false){
                depth = temp.getDepth();
                System.out.println("Bus temp: " + temp);
                System.out.println("Bus depth: " + depth);
                if(temp.containsT(T)){
                    System.out.println("FOUND");
                    return depth+1;
                }
                temp.setVisited();
                temp.setChildren(allBuses);
                ArrayList<Bus> children = temp.getChildren();
                for(int i = 0; i<children.size(); i++){
                    children.get(i).setDepth(depth+1);
                    queue.add(children.get(i));
                }
            }
		}
        return -1;
    }
	private int recurse(Bus node, int T, int ret, ArrayList<Bus> allBuses){
		int temp = -1;
        System.out.println("Node: " + node);
        System.out.println("Ret: " + ret);
		if(node.containsT(T))
			return 1;
		node.setVisited();
		node.setChildren(allBuses);
		ArrayList<Bus> children = node.getChildren();
		System.out.println("Children: ");
		for(int i = 0; i<children.size(); i++){
			System.out.println(i + ":  " + children.get(i));
			if(children.get(i).isVisited() == false){
				temp = recurse(children.get(i), T, ret, allBuses);
                if(temp > 0)
                    return temp + 1;
                return -1;
            }
		}
        return -1;
	}
    private void resetDepth(){
		for(int i = 0; i< allBuses.size(); i++){
			allBuses.get(i).setDepth(0);
		}

    }
	private void setAllBuses(int[][] routes){
		for(int i = 0; i< routes.length; i++){
			Bus b = new Bus(routes[i], 0);
			allBuses.add(b);
		}
		System.out.println("All Buses: ");
		for(int i = 0; i<allBuses.size(); i++){
		    System.out.println(allBuses.get(i));
		}
        System.out.println("*********");
	}
	private ArrayList<Bus> findBusS(ArrayList<Bus> allBuses, int s){
		ArrayList<Bus> temp = new ArrayList<Bus>();
        for(int i = 0; i < allBuses.size(); i++){
		    if(allBuses.get(i).containsT(s)){
                temp.add(allBuses.get(i));
            }
		}
		return temp;
	}
	// inner class
	private class Bus{
		private boolean visited;
		private ArrayList<Integer> route;
		private ArrayList<Bus> children;
        private int depth;

		public Bus(int[] route){
			children = new ArrayList<Bus>();
			this.route = new ArrayList<>(route.length);
			for (int i : route) {
				this.route.add(Integer.valueOf(i));
			}
			visited = false;
		}
		public Bus(int[] route, int depth){
            this.depth = depth;
			children = new ArrayList<Bus>();
			this.route = new ArrayList<>(route.length);
			for (int i : route) {
				this.route.add(Integer.valueOf(i));
			}
			visited = false;
		}
		public void setDepth(int depth){
			this.depth = depth;
		}
		public int getDepth(){
			return depth;
		}
		public void setVisited(){
			visited = true;
		}
		public boolean isVisited(){
			return visited;
		}
		public ArrayList<Integer> getRoute(){
			return route;
		}
		public ArrayList<Bus> getChildren(){
			return children;
		}
		private boolean containsT(int T){
			if(route.contains(new Integer(T)))
				return true;
			return false;
		}
		public String toString(){
			String ret = "";
			for(int i = 0; i < route.size(); i++) {
				ret+=route.get(i);
				if(i!= route.size()-1)
					ret+=" - > ";
			}
			return ret;
		}
		private boolean containsRoute(Bus temp){
			if(temp.isVisited() == false){
				ArrayList<Integer> tempRoute = temp.getRoute();
				for(int i = 0; i < tempRoute.size(); i++){
					if(route.contains(tempRoute.get(i))) {
                        //System.out.println("This: ");
					    //System.out.println(this);
                        //System.out.println("Contains: " + temp);
                        return true;
                    }
				}
			}
			return false;
		}
		public void setChildren(ArrayList<Bus> allBuses){
			System.out.println("Children: ");
            for(int i = 0; i < allBuses.size(); i++){
				if(containsRoute(allBuses.get(i))){
				    System.out.println("child : " + allBuses.get(i));
                    children.add(allBuses.get(i));
                }
			}
			//remove self
			children.remove(this);
		}
		public boolean equals(Object o){
			// If the object is compared with itself then return true
			if (o == this) {
				return true;
			}

			/* Check if o is an instance of Complex or not
			   "null instanceof [type]" also returns false */
			if (!(o instanceof Bus)) {
				return false;
			}

			// typecast o to Complex so that we can compare data members
			Bus c = (Bus) o;

			// Compare the data members and return accordingly
			return route.equals(c.getRoute());
		}
	}
}

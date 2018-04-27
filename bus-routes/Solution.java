import java.util.ArrayList;
// https://leetcode.com/problems/bus-routes/description/
public class Solution {
	public ArrayList<Bus> allBuses = null;

	public int numBusesToDestination(int[][] routes, int S, int T) {
		int ret = -1;
		// Assuming S only occurred in one bus
		allBuses = new ArrayList<Bus>(routes.length);
		Bus s = findBusS(routes, S);
		System.out.println("Root: " + s);
        setAllBuses(routes, s);
		if(s != null){
			ret = recurse(s, T, ret, allBuses);
			//if(ret!= -1){
			//	ret++;
			//}
		}
		System.out.println(ret);
		return ret;
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
			if(children.get(i).getVisited() == false){
				temp = recurse(children.get(i), T, ret, allBuses);
                if(temp > 0)
                    return temp + 1;
                return -1;
            }
		}
        return -1;
	}
	private void setAllBuses(int[][] routes, Bus s){
		for(int i = 0; i< routes.length; i++){
			Bus b = new Bus(routes[i]);
			allBuses.add(b);
		}
		allBuses.remove(s);
		System.out.println("All Buses: ");
		for(int i = 0; i<allBuses.size(); i++){
		    System.out.println(allBuses.get(i));
		}
	}
	private Bus findBusS(int[][] routes, int s){
		for(int i = 0; i< routes.length; i++){
			for(int j = 0; j < routes[i].length; j++){
				if(routes[i][j] == s){
					return new Bus(routes[i]);
				}
			}
		}
		return null;
	}
	// inner class
	private class Bus{
		private boolean visited;
		private ArrayList<Integer> route;
		private ArrayList<Bus> children;

		public Bus(int[] route){
			children = new ArrayList<Bus>();
			this.route = new ArrayList<>(route.length);
			for (int i : route) {
				this.route.add(Integer.valueOf(i));
			}
			visited = false;
		}
		public void setVisited(){
			visited = true;
		}
		public boolean getVisited(){
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
			if(temp.getVisited() == false){
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
			for(int i = 0; i < allBuses.size(); i++){
				if(containsRoute(allBuses.get(i))){
				    //System.out.println("Added: " + allBuses.get(i));
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

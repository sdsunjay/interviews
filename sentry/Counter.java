import java.util.Hashtable;
import java.util.Date;

public class Counter{

    Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
    Node[] array = new Node[5];

    /**
     * Increment counter using an array of Nodes
     */
    public void hit(){
        int i = (int) (new Date().getTime()/60000);
        int index = i%5;
        if(array[index] != null){
            if(i == array[index].time){
                array[index].setCounter(array[index].getCounter()+1);
            } else {
                array[index] = new Node(i);
            }
        }
        else{
          array[index] = new Node(i);
        }
    }
    public int count(){
        int sum = 0;
        for(int i = 0; i < 5; i++){
          if(array[i] != null){
            sum += array[i].getCounter();
          }
        }
        return sum;
    }
    /**
     * Increment counter using Hashtable
     */
    public void hit1(){
        int i = (int) (new Date().getTime()/60000);
        Integer counter = table.get(Integer.valueOf(i));
        if(counter == null){
          table.put(Integer.valueOf(i), Integer.valueOf(1));
        }
        else {
          table.put(Integer.valueOf(i), Integer.valueOf(counter + 1));
        }

    }
    /**
     * Get counter using Hashtable
     */
    public int count1(){
        // get the time
        int now = (int) (new Date().getTime()/60000);
        int sum = 0;
        for(int i = 0; i < 5; i++){
           Integer temp = table.get(Integer.valueOf(now - i));
           if(temp != null){
              sum += temp;
           }

        }
       return sum;

        // iterate through the queue until until we see a node that
        // if the node is outside the time limit of 5 mins, remove it, otherwise keep it
    }
    private boolean inFiveMins(int timeNow, int time1){
        int diff = timeNow - time1;
        if( diff > 5){
            return false;
        }
        else {
            return true;
        }

    }
}


public class Node {
  public int time;
  public int counter;
  public Node(int time){
    this.time = time;
    counter = 1;
  }
  public void setCounter(int value){
    counter = value;
  }
  public int getCounter(){
    return counter;
  }
}

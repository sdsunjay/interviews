/*

* Write a class to track a browser's history

1) add a new URL
2) get the last N unique URLs

We call add() 5 times with...

G, A, B, A, C

The call getLastNUniqueURLs(5)

[C, A, B, G]

*/
import java.util.ArrayList;
import java.util.HashSet;
public class History{

  ArrayList<String> myList = new ArrayList<String>(10000);
  public void add(String url){
    myList.add(url);
  }
  public ArrayList<String> getLastNUniqueURLs(int n){
    ArrayList<String> lastUnique = new ArrayList<String>();
    HashSet<String> uniqueSet = new HashSet<String>();
    int i = 0;
    String s;
    int counter = 0;
    while(i < n){
      int index = myList.size()-1-counter;
      if(index < 0){
        break;
      }
      s = myList.get(index);
      if(!uniqueSet.contains(s)){
        lastUnique.add(s);
        uniqueSet.add(s);
        i++;
      }
      counter++;
    }

    return lastUnique;
  }


}

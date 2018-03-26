import java.util.LinkedList;
import java.util.Iterator;

public class App{
    public static void main(String[] args){
        // if you are adding items to the middle or beginning of a list
        // you should use linkedlist
        // only if you are adding items to the end of a list should you use ArrayList
        LinkedList<String> animals = new LinkedList<String>();

        animals.add("Fox");
        animals.add("Cat");
        animals.add("Dog");
        animals.add("Rabbit");

        System.out.println("Using an iterator");
       
        // if you want to add items to a list while iterating through it, use ListIterator
        // before java 5
        Iterator<String> it = animals.iterator();
        while(it.hasNext()){
            String iter_animal = it.next();
            System.out.println(iter_animal); 
            
            // we can't do this with a normal for each loop
            // we can only do this with an iterator
            if(iter_animal.equals("Cat")){
                it.remove();
            }
        }

        System.out.println("Using a for each loop:");
        // modern iteration, Java 5 and later
        for (String animal: animals){
            System.out.println(animal);
        }
        
    }
}

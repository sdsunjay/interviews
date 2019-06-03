import java.io.*;
import java.util.*;
//import org.apache.commons.lang3.*;

public class Solution {
    public static class Dictionary {
        private String[] myList;
        //ArrayList<String> myList;
        int size;

        public Dictionary(int size){
            myList = new String[size];
            /* myList = new ArrayList<String>(size);
            for(int i = 0; i < size; i++){
                myList.add("");
            }*/
            this.size = size;
        }
        public String get(String key) {
            int index = key.hashCode() % size;
            //System.out.println("Get Index: " + index);
            print();
            return myList[index];
            // return myList.get(index);
        }

        public void set(String key, String value) {
            int index = key.hashCode() % size;
            System.out.println("Set Index: " + index);
            myList[index] = value;
            // System.out.println("Value: " + value);
            //myList.add(index, value);
        }

        public boolean contains(String key) {
            int index = key.hashCode() % size;
            return myList[index] == null;
            //return myList.get(index) != "";
        }
        public void print(){
            for(int i = 0; i < size; i++){
                System.out.println(i + ". " + myList[i]);
            }
        }
    }

    public static void main(String[] args) {
        Dictionary d = new Dictionary(20);
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] words = line.split(" ");
            if("get".equals(words[0])) {
                System.out.println(d.get(words[1]));
            } else if("set".equals(words[0])) {
                d.set(words[1], words[2]);
            } else if("contains?".equals(words[0])) {
                System.out.println(d.contains(words[1]));
            }
        }
    }
}


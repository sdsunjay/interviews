import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
   static ArrayList<Integer> nums = new ArrayList<Integer>(1000000);
   static int count = 0;

  public static void main(String[] args) {
    consume(-1);
    consume(2);
    consume(3);
    consume(4);
    System.out.println("Median: " + getMedian());
    System.out.println("Sum: " + getSum());
    System.out.println("Average: " + getAverage());




  }
  public static void consume(int num){
    nums.add(num);
    count++;
    // will auto resize
  }
  public static long getSum(){
    // runtime O(n)
    long sum = 0;

    for(int i = 0; i < count; i++){
      sum+= nums.get(i);
    }
    return sum;

  }
  public static double getAverage(){
     // runtime O(n)
    // A = Sum/N
    double result = 0;
     if(count == 0){
      return result;
    }

    long sum = getSum();
    //int sizeOfList = nums.size();
    result = ((double)sum)/((double)count);
    return result;
  }
   public static double getMedian(){
     // not sure

    /* Collections.sort method is sorting the
      elements of ArrayList in ascending order. */
      double median = 0;
     if(count == 0){
        return median;
     }
      // N Log N
     Collections.sort(nums);

     // if even
     if(count % 2 == 0){
        median = ((double)nums.get(count/2) + (double)nums.get(count/2)-1)/2;
     }
     else {
       median = nums.get(count/2);
     }
     return median;

  }

}
/*
You have a stream of integer values
1    consume(1)
2    consume(2)
3 ....
4
-1
getMedian() // -1 1 2 3 4 >> 2
0
getMedian() // -1 0 1 2 3 4 >> 1.5
-2
44
5
55
.. continuous stream of integers
<any valid int value>
< 1M numbers


define a class and implement the following methods:
1) consume(int value)
2) getSum() // return the running sum of all number passed to your class
3) getAverage() // running average
4) getMedian() // median - middle of a sorted set.

*/

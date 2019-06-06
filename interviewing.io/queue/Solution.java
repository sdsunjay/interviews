/*
(A)
Implement a non-generic data structure MyQueue of dynamic, unspecified size that has the following interface:

1. void push_back(int): Add the element to the back of the queue. Runtime: O(1)
2. int pop_front(): Remove and return the value at the front of the queue. If queue is empty, return -1. Runtime: O(1)
3. string stringify(): Return the values in the queue, from front to back, as a string with no delimiter. Return an empty string if the queue is empty. Runtime: O(N)

- Do not use any built-in data structures. This means you cannot use Javascript arrays, Swift arrays, Java ArrayLists, Python lists, etc. You are free to build any data structures you want.
- Run-time requirements are _not_ amortized. This means that worst case (not average case) has to be O(1) for push_back and pop_front.
- Assume input is well-formed
- Only use the Run button after you've implemented the required methods

(B)
Add the following method to your data structure:

4. int pop_back(): Remove and return the value at the tail of the queue. If queue is empty, return -1. Runtime: O(1)
*/

import java.io.*;
import java.util.*;
import org.junit.*;
import org.junit.runner.*;

public class Solution {
  @Test
  public void test1() {
    MyQueue q = new MyQueue();
    q.push_back(1);
    q.push_back(2);
    q.push_back(3);
    q.push_back(4);
    System.out.println(q.stringify());
    Assert.assertEquals( "1234", q.stringify());
    Assert.assertEquals( 1, q.pop_front());    // pop 1
    Assert.assertEquals( 2, q.pop_front());    // pop 2
    Assert.assertEquals( 3, q.pop_front());    // pop 3
    Assert.assertEquals( 4, q.pop_front());    // pop 4
    Assert.assertEquals(-1, q.pop_front());    // nothing to pop, return -1

  }

  @Test
  public void test2() {
    MyQueue q = new MyQueue();
    q.push_back(1);
    Assert.assertEquals( 1, q.pop_front());    // pop 1
    q.push_back(2);
    q.push_back(3);
    Assert.assertEquals( 2, q.pop_front());    // pop 2
    Assert.assertEquals( 3, q.pop_front());    // pop 3
    Assert.assertEquals( "", q.stringify());
    Assert.assertEquals(-1, q.pop_front());    // nothing to pop, return -1

  }

  public static class MyQueue{
    private class Node{
      int val;
      Node next;
      Node prev;
      public Node(int val){
        this.val = val;
         next = null;
      }
    }

    Node head;
    Node tail;

    public MyQueue(){
      tail = null;
      head = null;
    }

    public void push_back(int new_value){
      Node node = new Node(new_value);
      if(head == null){
        head = node;
      } else {
        tail.next = node;
      }
      tail = node;
    }

    public int pop_front(){

      if(head == null){
        return -1;
      }
      int temp = head.val;
      if(head == tail){
        tail = null;
        head = null;
      }
      else{
        head = head.next;
      }
      return temp;
    }

    public String stringify(){
      StringBuffer s = new StringBuffer("");
      Node temp = head;
      while(temp != null){
         s.append(Integer.toString(temp.val));
         temp = temp.next;
      }
      return s.toString();
    }

  }
  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}

// 1. In traditional object-oriented design, what is the purpose of an interface and how is it different from an abstract class

// 2. Create an interface called “Shape” with one method get_area.

// 3. Create a concrete “Circle” class that implements your interface. Add everything that is necessary for us to be able to create an instance of a Circle and to compute its area.

// 4. Write unit tests for the get_area method of the Circle class.

// 5. Now we want to add a draw() method to our interface. It should accept 3 parameters: integer x, y coordinates for the location on the output device where the origin of the shape should be located, and the third parameter is a supported graphics library instance. The provided library should be used to render the shape to the output device.

// Sample graphics library interfaces (entirely fictional and greatly simplified for the exercise):


import java.io.*;
import java.util.*;
import java.lang.*;
//import org.junit.*;
// import org.junit.runner.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Solution {
  public static void main(String[] args) {
    try {
    Circle circle;
    circle = new Circle(1.0);
    System.out.println("Expect 3.1415");
    System.out.println(circle.get_area());
    Gd gd = new Gd();
    circle.draw(gd, 2, 3);

    circle = new Circle(0);
    System.out.println(circle.get_area());

    //JUnitCore.main("Solution");
    } catch(IllegalArgumentException e){
      System.err.println(e.getMessage());
    }

  }
  /**
  @Test
    public void test_get_area() {
      Circle circle = new Circle(1.0);
      double area = circle.get_area();
      Assert.assertEquals(area, 3.141592653589793);
    }
    */
}

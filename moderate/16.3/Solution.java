import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
/**
 * Given two string line segments (represented as a start point and an end point), compute the point
 * of intersection, if any.
 */
class Solution {
  public static void main(String[] args) {
    Point start1 = new Point(3, 1);
    Point end1 = new Point(5, 4);
    Point start2 = new Point(2, 2);
    Point end2 = new Point(5, 2);
    System.out.println(intersection(start1, end1, start2, end2));

  }
  /*public static boolean isIntersection(Point a, Point b){
    a = (1,1) (2,1)
    b = (4,1) (1,1)
    }*/
  public static Point intersection(Point start1, Point end1, Point start2, Point end2){
    /* Rearranging these so that, in order of x values: start is before end and
     * point 1 is before point 2. This will make some of the later logic simpler */
    if(start1.x > end1.x){
      swap(start1, end1);
    }
    if(start2.x > end2.x){
      swap(start2, end2);
    }
    if(start1.x > start2.x){
      swap(start1, start2);
      swap(end1, end2);
    }
    /* Compute lines (including slope and y-intercept). */
    Line line1 = new Line(start1, end1);
    Line line2 = new Line(start2, end2);

    /* if the lines ARE parallel, they intercept only if they have the same y-intercept
     * and start 2 is on line 1. */
    if(line1.slope == line2.slope) {
      if(line1.yintercept == line2.yintercept && isBetween(start1.x, start2.x, end1.x)) {
        return start2;
      }
      return null;
    }
    /* if the lines are NOT parallel */
    /* Get the intersection coordinate. */
    double x = (line2.yintercept - line1.yintercept) / (line1.slope - line2.slope);
    double y = x * line1.slope + line1.yintercept;
    Point intersection = new Point(x, y);

    /* Check if within line segment range */
    if(isBetween(start1.y, intersection.y, end1.y) && isBetween(start2.y, intersection.y, end2.y)) {
      return intersection;
    }
    return null;
  }
  /**
   * Checks if middle is between start and end.
   */
  private static boolean isBetween(double start, double middle, double end) {
    if(start > end) {
      return end <= middle && middle <= start;
    }
    else {
      return start <= middle && middle <= end;
    }
  }
  /**
   * Swap coordinates of point one and two.
   */
  private static void swap(Point one, Point two){
    double x = one.x;
    double y = one.y;
    one.setLocation(two.x, two.y);
    two.setLocation(x, y);
  }
  public static class Line {
    public static double slope, yintercept;

    public Line(Point start, Point end){
      double deltaX = end.x - start.x;
      double deltaY = end.y - start.y;
      slope = deltaY / deltaX;
      yintercept = end.y - (slope * end.x);
    }
  }
  public static class Point {
    public static double x, y;

    public Point(double a, double b){
      x = a;
      y = b;
    }
    public static void setLocation(double a, double b){
      x = a;
      y = b;
    }
    public String toString(){
      return "(" + x + ", " + y + ")";
    }
  }
}

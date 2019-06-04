// Find the largest rectangular area possible in a given histogram
// where the largest rectangle can be made of a number of contiguous bars.
// For example, consider the following histogram with 7 bars of heights
// {6, 2, 5, 4, 5, 1, 6}. The largest possible rectangle possible is 12
// (see the below figure, the max area rectangle

//    6                 6
// 6 ███    5     5    ███
// 5 ███   ███ 4 ███   ███
// 4 ███   █████████   ███      █████████
// 3 ███ 2 █████████   ███      █████████
// 2 ███████████████ 1 ███      █████████ 4 height
// 1 █████████████████████      █████████
//    1  2  3  4  5  6  7        3 width


//
// 6
// 5                    4
// 4     3             ███      █████████
// 3    ███ 2     2    ███      █████████
// 2  1 ██████ 1 ███ 1 ███      █████████ 4 height
// 1 █████████████████████      █████████
//    1  2  3  4  5  6  7        3 width

import java.io.*;
import java.util.Stack;
class Solution {
	public static void main (String[] args) {
		//System.out.println("Hello Java");
    int[] heights;
    heights = new int[]{6, 2, 5, 4, 5, 1, 6};
    //System.out.println(getMaxArea(heights));
    System.out.println(getMaxAreaStack(heights));

    heights = new int[]{1, 3, 2, 1, 2, 1, 4};
    //System.out.println(getMaxArea(heights));
    System.out.println(getMaxAreaStack(heights));
	}
  /**
   * Naive Solution - actually written during the interview
   */
  // array integers which represent the height of the histogram
  // { 6, 2, 5, 4, 5, 1, 6}
  // 6, 6, 6, 6, 3, 6
  // return max area
  public static int getMaxArea(int[] heights){
    int maxArea = 0;
    int temp = 0;
    int lowestHeight;
    int[] numbers = new int[heights.length];
    for(int j = 0; j < heights.length; j++){
      lowestHeight = heights[j];
      // loop through the numbers
      for(int i = j; i < heights.length; i++){

        if(heights[i] < lowestHeight){

          lowestHeight = heights[i];
          System.out.println("lowestHeight " + lowestHeight);
        }
        temp = (i+1)*lowestHeight;

        if(temp > maxArea){
          System.out.println("Temp: " + temp);
          maxArea = temp;
        }
      }

    }

    // calculate area as we go
    // store the max area
    // O(N)
    return maxArea;

  }
  /**
   * Optimal Solution - Written after the interview.
   */
  public static int getMaxAreaStack(int[] heights){
    Stack<Integer> positions = new Stack<Integer>();
    int maxArea = 0;
    int tempArea;
    int tp;
    int n = heights.length;
    int i = 0;
    while(i < n){
      //top = stack_heights.peek();
      // If this bar is higher than the bar on top stack, push it to stack
      if (positions.empty() || heights[positions.peek()] <= heights[i]){
        positions.push(i++);
      }
      else {
        tp = positions.peek();
        positions.pop();
        tempArea = heights[tp] * (positions.empty() ? i : i - positions.peek() - 1);
        // System.out.println("tempArea: " + tempArea);
        if(tempArea > maxArea){
          maxArea = tempArea;
        }
      }
    }

    // System.out.println("BREAK");
    while(!positions.empty()){
      tp = positions.peek();
      positions.pop();
      tempArea = heights[tp] * (positions.empty() ? i : i - positions.peek() - 1);
      // System.out.println("tempArea: " + tempArea);
      if(tempArea > maxArea){
        maxArea = tempArea;
      }
    }
    return maxArea;
  }


}


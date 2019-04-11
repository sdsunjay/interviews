/**
# You have a 2-D array with n numbers on the nth line, find the minimum sum from top to bottom along a left-or-right-child path
#
#           1
#        5    2
#     1    2    3
#   4    2   1    5
#
# Input: [[1], [5, 2], [1, 2, 3], [4, 2, 1]]
# Result: 1 + 2 + 2 + 1 = 6

#           1     (0, 0)
#        5    2   (x=1, y=1)
#     1    8    6
#   4    2   1    5
#
# 1 + 2 + 6 + 1
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {
    public static void main(String args[] ) throws Exception {
        //int[][] nums = new nums[4][];
        //int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
        int[][] nums= new int[][]{{1}, {5, 2}, {1, 2, 3}, {4, 2, 1, 5}};
        int lowestSum = findLowestSum(nums);
        System.out.println(lowestSum);
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    }
    public static class Node{
        int x, y, val, sum;
        public Node(int x, int y, int val, int sum){
            this.x = x;
            this.y = y;
            this.val = val;
            this.sum = sum;
        }
    }
    public static int findLowestSum(int[][] nums){
        Stack<Node> stack = new Stack<Node>();
        Node root = new Node(0, 0, nums[0][0], nums[0][0]);
        stack.push(root);
        int sum = 0;
        int lowestSum = 0;
        Node temp;
        int index = 0;
        boolean firstLeaf = true;
        while(!stack.isEmpty()){
            temp = stack.pop();
            // this is wrong
            //sum+=temp.val;
            //if leaf, check if sum is less than lowest sum
            if(temp.x+1 == nums.length){
                // System.out.println("Sum: " + temp.sum);
                if(firstLeaf){
                    lowestSum = temp.sum;
                    firstLeaf = false;
                }
                else{
                    if(temp.sum < lowestSum){
                        lowestSum = temp.sum;
                    }
                }
            }

              // if not leaf,
            else {
                // this is left node
                //if(nums[something].length == temp.y]){
                    stack.push(new Node(temp.x+1, temp.y, nums[temp.x+1][temp.y], temp.sum + nums[temp.x+1][temp.y]));
                //}
                // this is right node
               //if(nums[something].length == temp.y]){
                    stack.push(new Node(temp.x+1, temp.y+1, nums[temp.x+1][temp.y+1], temp.sum + nums[temp.x+1][temp.y+1]));
                //}
            }

        }
        return lowestSum;
    }
}

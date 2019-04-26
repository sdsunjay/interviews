import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

// String[][] names = { {"John", "Smith"}, {"Javin", "Paul"}, {"James", "Gosling"}, };


class Solution {
  public static void main(String[] args) {
    int[][] matrix = { {0, 0, 1}, {0,1,1}, {0,0,1 }, };
  //  names = { {0, 1, 1, 1, 1, 1}
//0 0 0 0 0 1
    //int[][] matrix = new int[]{0,0,1,1,1}
    System.out.println(maxOnes(matrix));
  }
  public static int maxOnes(int[][] matrix){
    int maxOnes = 0;
    int maxRow = 0;
    int tempOnes = 0;
    int tempRow = 0;

    int startPoint = matrix[0].length-1;
    // rows
    for(int i = 0; i< matrix.length; i++){
    //cols
      tempOnes = 0;
      for(int j = startPoint; j>= 0; j--){
          if(matrix[i][j] == 1){
              tempOnes++;
              tempRow = i;
          }
          else if(matrix[i][j] == 0){
              break;
          }
      }
      if(tempOnes > maxOnes){
        maxOnes = tempOnes;
        maxRow = tempRow;
        startPoint = matrix[i+1].length - maxOnes;
       // startPoint would be updated, based on MaxOnes
      }

    }
    return maxRow;
  }
}


/*
Your previous Plain Text content is preserved below:

# Given a matrix
# - Each row is sorted
# - Each row has only 0s and 1s
# > Return the row no. which had max no. of 1s

0 0 1
0 1 1 > row no 1
0 0 1

0 0 0 0 1 > row no. 0
0 0 0 1 1
0 0 0 0 1

N = rows
M = cols

O(M)



0 1 1 1 1 1 > col = 1, 5 1s
1 1 1 1 1 1

0 1 1 1 1 1
0 0 0 0 0 1

null

1 1 1 1
1 1 1 1
1 1 1 1

0 0 0 0
0 0 0 0

0 1 1 1 1 1
1 1 1 1 1 1
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Two-dimensional grid of cells, each of which is dead or alive (2-D array of booleans / 0, 1)
 * - interior cell has 8 neighbors (top, bottom, left, right, diagonals)
 * - edge cells has 5 neighbors
 * - corner cells have 3 neighbors
 *
 * If the cell is alive: if it has 2 or 3 alive neighbors, it stays alive. Otherwise, it dies.
 * If the cell is dead: if it has exactly 3 alive neighbors, it becomes alive. Otherwise, it stays dead.
 * The state of each cell is determined only by the state of its neighbors in the last iteration.
 *
 * Write a function that takes in an existing board state (2D array) and returns a new board state (2D array)
 */

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    }
    // 0 - dead
    // 1 - alive
    public static int[][] getBoard(int[][] board){
        int[][] newBoard = new int[board.length][board[0].length];
        int aliveNeighbors;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; i++){
                aliveNeighbors = getAliveNeighbors(board, i, j);
                if(board[i][j] == 1){
                    //alive
                    if(aliveNeighbors == 2 || aliveNeighbors == 3){
                        newBoard[i][j] = 1;
                    }
                    else{
                        newBoard[i][j] = 0;
                    }
                }
                else{
                    // dead
                    if(aliveNeighbors == 3){
                        newBoard[i][j] = 1;
                    }
                    else {
                        newBoard[i][j] = 0;
                    }
                }
            }
        }
        return newBoard;
    }
    // Return the number of alive neighbors around position (i, j) in board
    private static int getAliveNeighbors(int[][] board, int indexI, int indexJ){
        int count = 0;
        for(int i = indexI-1; i <= indexI+1; i++){
            for(int j = indexJ-1; j <= indexJ+1; j++){
                if(i >= 0 && i < board.length){
                    if(j >= 0 && j < board[i].length){
                        if(board[i][j] == 1){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    private static int numAliveNeighbors(int[][] board, int i, int j, int alive){

      int aliveNeighbors = 0;
      if(board[i][j] == alive){
        if(i-1 > 0){
          if(board[i-1][j] == alive){
            aliveNeighbors++;
          }
          if(j-1 > 0 && board[i-1][j-1] == alive){
            aliveNeighbors++;
          }

        }
        if(j-1 > 0)
          if(board[i][j-1] == alive){
            aliveNeighbors++;
          }
      }
      if(i+1 < board.length && board[i+1][j] == alive){
        aliveNeighbors++;
      }
      if(j+1 < board[i].length && board[i][j-1] == alive){
        aliveNeighbors++;
      }
      return aliveNeighbors;
    }



    // return true if board should be alive at that index
}

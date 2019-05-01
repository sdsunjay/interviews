import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
// 16.4 Tic Tac Win: Design an algorithm to figure out if somoene has won a game of tic-tac-toe.
class Solution {
  public static void main(String[] args) {
  }
  enum Piece { Empty, Red, Blue };
  private static Piece hasWon(Piece[][] board){
    for(int i = 0; i < board.length; i++){
      /* Check Rows */
      if(hasWinner(board[i][0], board[i][1], board[i][2])){
        return board[i][0];
      }
      /* Check Columns */
      if(hasWinner(board[0][i], board[1][i], board[2][i])){
        return board[0][i];
      }
    }
    /* Check Diagonal */
      if(hasWinner(board[0][0], board[1][1], board[2][2])){
        return board[0][0];
      }
      if(hasWinner(board[0][2], board[1][1], board[2][0])){
        return board[0][2];
      }
      return Piece.Empty;
  }
  private static boolean hasWinner(Piece p1, Piece p2, Piece p3) {
    if(p1 == Piece.Empty){
      return false;
    }
    return p1 == p2 && p2 == p3;
  }
}

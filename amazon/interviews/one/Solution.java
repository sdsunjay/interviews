// Goodreads is a social media platform for books.
// Users use it to keep track of their favorite books and
// network with friends to discover new books. Given a user,
// could you find all the books in their social network?

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {

  public static void main(String[] args) {
    User u = new User();
    Hashtable<String, Book> myBooks = new Hashtable<String, Book>();
    HashSet<User> users = new HashSet<User>();
    users.add(u);
    recursiveallBooks(u, myBooks, users, 0, 5);
  }


  //id list books and list of friends
  public static List<Book> allBooks(User u, List<User> networkUser){
    List<Book> result = u.getMyList();
    List<Book> friendBookList;
    for(int i = 0; i < networkUser.size(); i++ ){
      User friend = networkUser.get(i);
      friendBookList = friend.getMyList();
      for(int j = 0; j < friendBookList.size(); j++ ){
        result.add(friendBookList.get(j));
      }
    }
    return result;
  }
  public static Hashtable<String, Book>  recursiveallBooks(User u, Hashtable<String, Book> myBooks, HashSet<User> users, int level, int maxLevels){
    if(level == maxLevels){
      return myBooks;
    }
    List<Book> myList = u.getMyList();
    List<User> myFriends =  u.getMyFriends();
    u.getMyFriends();
      for(int i = 0; i < myList.size(); i++){
        Book book = myList.get(i);
        myBooks.put(book.title, book);
      }
    for(int i = 0; i < myFriends.size(); i++){
      User temp = myFriends.get(i);
        if(!users.contains(temp)){
          users.add(temp);
          recursiveallBooks(temp, myBooks, users, level++, maxLevels);
        }

    }
    return myBooks;
  }
  public static class Book{
    public String title;
    public Book(String title){
      this.title = title;
    }
  }
  public static class User {

    private static List<User> myFriends;
    private static List<Book> myBooks;
    public User() {
      myFriends = new ArrayList<User>();
      myBooks = new ArrayList<Book>();
    }
    public static List<User> getMyFriends(){
      return myFriends;
    }
    public static List<Book> getMyList(){
      return myBooks;
    }
  }
}

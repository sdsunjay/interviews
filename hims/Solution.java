import java.util.Arrays;
public class Solution {


  public static void main(String args[]) {
    History history = new History();
    history.add("reddit.com");
    history.add("google.com");
    history.add("yahoo.com");
    history.add("facebook.com");
    history.add("instagram.com");
    history.add("facebook.com");
    history.add("wikipedia.com");
    history.add("baidu.com");
    history.add("google.com");
    history.add("twitter.com");
    System.out.println(Arrays.toString(history.getLastNUniqueURLs(10).toArray()));
    System.out.println(Arrays.toString(history.getLastNUniqueURLs(5).toArray()));
    System.out.println(Arrays.toString(history.getLastNUniqueURLs(8).toArray()));
  }
}

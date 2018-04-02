import java.util.LinkedList;
import java.util.Iterator;

public class App{
    public static void main(String[] args){
        UrlLibrary urlLibrary = new UrlLibrary();
        for(String url: urlLibrary){
            System.out.println(url);
        }

    }
}

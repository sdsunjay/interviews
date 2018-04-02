import java.util.LinkedList;
import java.util.Iterator;

public class UrlLibrary implements Iterable<String>{
    private LinkedList<String> urls = new LinkedList<String>();
    
    public UrlLibrary() {
        urls.add("https://cavebookofprogramming.com");
        urls.add("https://facebook.com");
        urls.add("https://n.pr");

    }
    @Override
    public Iterator<String> iterator() {
        return urls.iterator();
    }
}

// A templated Java singly linked list
public class ListElement<T>{
    public ListElement(T value){
        data = value;
    }
    public ListElement<T> next(){
        return next;
    }
    public T Value(){
        return data;
    }
    public void setNext(ListElement<T> elem){
        next = elem;
    }
    public void setValue(T value){
        data = value;
    }
    /**
     * Returns an ListElement object, which represent the new head of the LinkedList. For example the method can be invoked like this: head = insertInFront(head, data);
     *
     * @param  list the current head of the LinkedList object 
     * @param  data the new data to add to the LinkedList
     * @return      the new head of the LinkedList
     * @see         ListElement
     */

    public ListElement<Integer> insertInFront(ListElement<Integer> list,  Integer data){
        ListElement<Integer> l = new ListElement<Integer>(data);
        l.setNext(list);
        return l;
    }

    
    /**
     * Finds the ListElement object containing the data.
     *
     * @param  head the current head of the LinkedList object 
     * @param  data the data to find in the LinkedList
     * @return      the node containing the data of the LinkedList
     * @see         ListElement
     */
    public ListElement<Integer> find(ListElement<Integer> head, int data){
        ListElement<Integer> elem = head;
        // Note: Always test for the end of a linked list as you traverse it
        while(elem != null && elem.value() != data){
            elem = elem.next();
        }
        return elem;
    }

    private ListElement<T> next;
    private T data;
}

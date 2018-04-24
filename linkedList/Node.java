// HackerRank Data Structures: Cycles in a Linked List
//https://youtu.be/MFOAbpfrJ8g
// Does the linked list have a cycle
public class Node {

    public Node next;
    public int value;

    public boolean hasCycle(Node head){

        if(head == null){
            return false;
        }

        Node tortoise = head;
        Node hare = head.next;

        while(hare != null && hare.next != null && tortoise != null){
            if(hare.value == tortoise.value){
                return true;
            }
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return false;
    }

}

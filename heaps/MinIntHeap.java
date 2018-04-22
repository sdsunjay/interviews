import java.util.Arrays;

public class MinIntHeap {

    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1; }
    private int getRightChildIndex(int parentIndex) { return 2 * parentIndex + 2; }
    private int getParentIndex(int childIndex) { return (childIndex - 1) / 2;}

    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }
    private boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }
    private boolean hasParent(int index) { return getParentIndex(index) >= 0; }

    private int leftChild(int index) { return items[getLeftChildIndex(index)]; }
    private int rightChild(int index) { return items[getRightChildIndex(index)]; }
    private int parent(int index) { return items[getParentIndex(index)]; }

    /**
     * Swap the two item in the heap
     */
    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] =  items[indexTwo];
        items[indexTwo] = temp;
    }

    /**
     * Double the capacity of the heap, copying items into the new heap
     */
    private void ensureExtraCapacity() {
        if(size == capacity){
            items = Arrays.copyOf(items, capacity * 2);
            capacity *=2;
        }
    }
    /**
     * Return min int in the heap
     */
    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    /**
     * Remove the min item from the heap
     */
    public int poll(){
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        //move the largest item to the min element
        items[0] = items[size - 1];
        size--;
        // move the largest item down, so the new min is the root
        heapifyDown();
        return item;
    }

    /**
     * Add a new item to the heap
     */
    public void add(int item){
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    /**
     * Move the items in the tree up
     */
    private void heapifyUp(){
        /**
         * int index - the last item added to the tree
         */
        int index = size - 1;
        while( hasParent(index) && parent(index) > items[index]){
            index = getParentIndex(index);
        }
    }

    /**
     * Move the items in the tree down
     */
    private void heapifyDown(){
        int index = 0;
        // we only need to check for the left child because
        // if there is no left child then there is certainly no right child
        while (hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallerChildIndex]){
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }
/**
 * print the tree
 * shamelessly copied from https://stackoverflow.com/questions/36385868/java-how-to-print-heap-stored-as-array-level-by-level
 */
    public void dump() {
        int height = log2(size) + 2;

        for (int i = 1, len = size+1; i < len; i++) {
            int x = items[i];
            int level = log2(i) + 1;
            int spaces = (height - level + 1) * 2;

            System.out.print(stringOfSize(spaces, ' '));
            System.out.print(x);

            if((int)Math.pow(2, level) - 1 == i) System.out.println();
        }
        System.out.println();
    }

    private String stringOfSize(int size, char ch) {
        char[] a = new char[size];
        Arrays.fill(a, ch);
        return new String(a);
    }

    // log with base 2
    private int log2(int x) {
        return (int)(Math.log(x) / Math.log(2)); // = log(x) with base 10 / log(2) with base 10
    }

}

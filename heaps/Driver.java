public class Driver
{


	public static void main(String[] args)
	{
		int[] a = {3, 4, 8, 9, 7, 10, 9, 15, 20, 13, 9, 14, 20, 11, 19};
		MinIntHeap heap = new MinIntHeap();
        for (int i = 0 ; i < a.length ; i++){
            System.out.println("Added: " + a[i]);
            heap.add(a[i]);
        }
        System.out.println(heap.peek());
        heap.dump();
        for (int i = 0 ; i < a.length-8 ; i++){
            System.out.println("Removed: " + heap.poll());
        }
        System.out.println(heap.peek());
        heap.dump();
	}
}

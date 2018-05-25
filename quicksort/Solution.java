import java.util.Arrays;
import java.util.Random;

public class Solution{

    public static void swap(int[] array, int left, int right){
        int temp;
        temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    private static int partition(int[] array, int left, int right, int pivot){
        while( left <= right){
            while( array[left] < pivot ){
                left++;
            }
            while (array[right] > pivot){
                right--;
            }

            if(left <= right){
                swap(array, left, right);
                left++;
                right--;
                // System.out.println(Arrays.toString(array));
                // let's see the magic happening
            }
        }
        return left;
    }

    private static void quicksort(int[] array, int left, int right){
        if( left >= right)
            return;

        // randomly pick a pivot
        Random rand = new Random();
        int  pivot = array[rand.nextInt(array.length-1)];
        //int pivot = array[(left + right) / 2)];
        // return dividing point between left and right
        int index = partition(array, left, right, pivot);
        quicksort(array, left, index - 1);
        quicksort(array, index, right);
    }

    /**
     * Quicksort - Recursive
     * @param array - the array we are sorting
     * @return true - the integer exists in the array, otherwise false
     */
    public static void quicksort(int[] array){
        quicksort(array, 0, array.length - 1);
    }

    public static void main(String[] args){

        int[] array = { 15, 3, 9, 8, 5, 2, 7, 1, 6, 4};
        System.out.println("Input: " + Arrays.toString(array));
        quicksort(array);
        System.out.println("Output: " + Arrays.toString(array));
    }

}

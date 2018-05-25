import java.io.*;
import java.util.*;
import java.math.*;
import java.util.regex.*;

public class Solution{

    private static boolean binarySearchRecursive(int[] array, int x, int left, int right){
        if (left > right){
            return false;
        }

        // this can actually overflow
        //int mid = (left + right) / 2;
        // this will prevent the overflow
        int mid = left + ((right - left) / 2);

        if (array[mid] == x){
            return true;
        } else if (x < array[mid]) {
            return binarySearchRecursive(array, x, left, mid - 1);
        } else {
            return binarySearchRecursive(array, x, mid + 1, right);
        }
    }

    /**
     * Binary Search - Recursive
     * @param array - the array we are searching
     * @param x - the integer we are searching for
     * @return true - the integer exists in the array, otherwise false
     */
    public static boolean binarySearchRecursive(int[] array, int x){
        return binarySearchRecursive(array, x, 0, array.length - 1);
    }
    /**
     * Binary Search - Iterative
     * @param array - the array we are searching
     * @param x - the integer we are searching for
     * @return true - the integer exists in the array, otherwise false
     */
    public static boolean binarySearchIterative(int[] array, int x){
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) / 2);
            if (array[mid] == x) {
                return true;
            } else if ( x < array[mid]){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args){

        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(array));
        System.out.println("Expects: True");
        System.out.println(binarySearchRecursive(array, 9));
        System.out.println("Expects: False");
        System.out.println(binarySearchRecursive(array, 11));
        System.out.println("Expects: True");
        System.out.println(binarySearchIterative(array, 9));
        System.out.println("Expects: False");
        System.out.println(binarySearchIterative(array, 11));
    }

}

import java.util.HashSet;
// Given two arrays (sorted + distinct), find # of element in common
public class Main{

    /**
     * Solve using pointers
     * @param arr1 - array of integers 1
     * @param arr2 - array of integers 2
     */
    //O(A)
    private static int optimal_solution(int[] arr1, int[] arr2){
        int i = 0;
        int j = 0;
        int count = 0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] == arr2[j]){
                count++;
                // all the elements are distinct, so we can do this
                i++;
                j++;
            } else if (arr1[i] > arr2[j]){
                j++; // don't change i, move j
            } else {
                i++; // don't change j, move i
            }
        }
        return count;
    }
    /**
     * Solve using a hast set
     * @param arr1 - array of integers 1
     * @param arr2 - array of integers 2
     */
    //O(A+B)
    private static int hash_solution(int[] arr1, int[] arr2){

        HashSet<Integer> set1 = new HashSet<Integer>();
        int count = 0;
        for(int i = 0; i< arr1.length; i++){
            //store each element in a hashset
            set1.add(new Integer(arr1[i]));
        }
        // check if it exists in the other array
        for(int i = 0; i< arr2.length; i++){
            if(set1.contains(new Integer(arr2[i]))){
                count++;
            }
        }
        return count;
    }
/**
 * Main
 */
    public static void main(String[] args){
        int[] arr1 = {2, 5, 7, 9, 21, 33, 35, 37};
        int[] arr2 = {1, 5, 11, 13, 14, 15, 35, 39};
        int count = 0;
        count = hash_solution(arr1, arr2);
        System.out.println("Count of same numbers (hashset): " + count);
        count = optimal_solution(arr1, arr2);
        System.out.println("Count of same numbers (pointers): " + count);

    }


}

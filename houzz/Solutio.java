import java.util.Arrays;
class Solutio {
  public static void main(String[] args) {
    int[] arr = new int[]{5, 4, 3, 2, 1};
    mergeSort(arr, arr.length);
    System.out.println("Sorted: ");
    System.out.println(Arrays.toString(arr));
    arr = new int[]{1, 2, 3, 5, 4};
    mergeSort(arr, arr.length);
    System.out.println("Sorted: ");
    System.out.println(Arrays.toString(arr));
    arr = new int[]{2, 2, 2, 1, 1, 1, 1, 1,1};
    mergeSort(arr, arr.length);
    System.out.println("Sorted: ");
    System.out.println(Arrays.toString(arr));
    arr = new int[]{4, 1, 2, 0, 5, 9, 6, 6, 5, 5, 5,};
    mergeSort(arr, arr.length);
    System.out.println("Sorted: ");
    System.out.println(Arrays.toString(arr));
  }
  //
  public static void mergeSort(int[] arr, int n){
    if(n <= 1){
      return;
    }
    int midpoint = n/2;
    int[] left = new int[midpoint];
    int[] right = new int[n - midpoint];

    for(int i = 0; i < midpoint; i++){
     left[i] = arr[i];
    }
    for(int i = midpoint; i < n ; i++){
     right[i - midpoint] = arr[i];
    }
    // call it on each half
    // not correct
    mergeSort(left, midpoint);
    mergeSort(right, n - midpoint);
    // put it back together
    merge(arr, left, right);
  }
  public static void merge(int[] arr, int[] left, int[] right){
    int i = 0;
    int j = 0;
    int index = 0;
    while(i < left.length && j < right.length){
      if(left[i] < right[j]){
        arr[index] = left[i];
        i++;
        index++;
      }
      else{
        arr[index] = right[j];
        j++;
        index++;
      }
  }
    // finish it off.. potentially
  while(i < left.length){
    arr[index] = left[i];
    index++;
    i++;
  }
  while(j < right.length){
    arr[index] = right[j];
    index++;
    j++;
  }

  }
}


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {

    public static void main(String[] args) {
        int key = 0;
        int[] array = new int[0];
        key = StdIn.readInt();

        array = StdIn.readAllInts();

        int result = test(array, key);
        StdOut.print(result);
    }

   public static int test(int[] array, int key) {
        int lo = 0, hi = array.length - 1;

        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(key < array[mid]){
                hi = mid - 1;
            } else if(key > array[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
   }


}


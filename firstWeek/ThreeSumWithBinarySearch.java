import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class ThreeSumWithBinarySearch {

    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n ; j++ ){
                    if(binarySearch(a ,-(a[i] + a[j])) != -1 ){
                        count++;
                    }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[]  a = StdIn.readAllInts();
        Stopwatch stopwatch = new Stopwatch();
        StdOut.println(count(a));
        double time = stopwatch.elapsedTime();
        StdOut.println(time);
    }

    private static int binarySearch(int[] array , int key){
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

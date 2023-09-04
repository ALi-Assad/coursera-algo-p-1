package secondWeek.Shell;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Shell {

    public static void main(String[] args) {
        int[] array = StdIn.readAllInts();
        Integer[] newArray = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            Integer item = Integer.valueOf(array[i]);
            newArray[i] = item;
        }

        StdOut.println("before sort: ");
        for (int i = 0; i < newArray.length; i++) {
            StdOut.println(array[i]);
        }
        sort(newArray);
        StdOut.println("---------------------------------");
        StdOut.println("after sort: ");
        for (int i = 0; i < newArray.length; i++) {
            StdOut.println(newArray[i]);
        }

    }

    private static void sort(Comparable[] array){
        int h = 1, n = array.length;
        while (h < n/3) h = 3*h + 1;

        while (h >= 1){
            for (int i = h ; i < n; i++){
                for (int j = i; j >= h && less(array[j], array[j - h]); j-=h){
                    exch(array, j, j-h);
                }
            }
            h = h/3;
        }
    }

    private static boolean less(Comparable firstItem, Comparable secondItem) {
        return firstItem.compareTo(secondItem) < 0;
    }

    private static void exch(Object[] array, int firstIndex, int secondIndex) {
        Object swap = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = swap;
    }
}

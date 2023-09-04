package secondWeek.Insertion;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Insertion {


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
        StdOut.println("-----------------------");
        StdOut.println("after sort: ");
        for (int i = 0; i < newArray.length; i++) {
            StdOut.println(newArray[i]);
        }
    }




    private static void sort(Comparable[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (less(array[j], array[j-1])) {
                    exch(array, j, j-1);
                }
            }
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

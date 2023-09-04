package secondWeek.Selection;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Selection {

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

        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(array[j], array[min]) < 0) {
                    min = j;
                }
            }
            exch(array, i, min);
        }
    }

    private static int less(Comparable firstItem, Comparable secondItem) {
        return firstItem.compareTo(secondItem);
    }

    private static void exch(Object[] array, int firstIndex, int secondIndex) {
        Object swap = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = swap;
    }

}

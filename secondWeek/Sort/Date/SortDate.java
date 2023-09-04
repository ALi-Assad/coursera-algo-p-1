package secondWeek.Sort.Date;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class SortDate {

    public static void main(String[] args) {
        int n = StdIn.readInt();
        DateComparable[] a = new DateComparable[n];
        for (int i = 0; i < n; i++) {
            int y = StdRandom.uniformInt(n);
            int m = StdRandom.uniformInt(n);
            int d = StdRandom.uniformInt(n);
            a[i] = new DateComparable(y, m, d);
        }

        StdOut.println("before sort: ");
        for (int i = 0; i < n; i++) {
            StdOut.println(a[i].year + ":" + a[i].month + ":" + a[i].day);
        }

        Insertion.sort(a);
        StdOut.println("-----------------------");
        StdOut.println("after sort: ");
        for (int i = 0; i < n; i++) {
            StdOut.println(a[i].year + ":" + a[i].month + ":" + a[i].day);
        }
    }


    private static void sort(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (j > 0 && (more(array[j - 1], array[j]) > 0)) {
                    exch(array, j, j - 1);
                }
            }
        }
    }

    private static int more(Comparable firstItem, Comparable secondItem) {
        return firstItem.compareTo(secondItem);
    }

    private static void exch(Object[] array, int firstIndex, int secondIndex) {
        Object swap = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = swap;
    }

    private static boolean isSorted(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            if (more(array[i], array[i + 1]) > 1) {
                return false;
            }
        }
        return true;
    }
}

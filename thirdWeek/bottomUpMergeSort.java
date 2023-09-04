package thirdWeek;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class bottomUpMergeSort {

    public static void main(String[] args) {
        int[] array = StdIn.readAllInts();
        Integer[] newArray = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            Integer item = Integer.valueOf(array[i]);
            newArray[i] = item;
        }
        sort(newArray);

        StdOut.println("after sort: ");
        for (int i = 0; i < newArray.length; i++) {
            StdOut.println(newArray[i]);
        }
    }

    public static void merge(Comparable array[], Comparable[] aux, int lo, int mid, int hi) {

        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) array[k] = aux[j++];
            else if (j > hi) array[k] = aux[i++];
            else if (less(aux[i], aux[j])) array[k] = aux[i++];
            else array[k] = aux[j++];
        }
    }

    public static void sort(Comparable array[]) {
        int N = array.length;
        Comparable[] aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            StdOut.println("sz: " + sz);
            StdOut.println("---------------");
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                StdOut.println("lo: " + lo);
                StdOut.println("min: " + Math.min(lo + sz + sz - 1, N - 1));
                merge(array, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    private static boolean less(Comparable firstItem, Comparable secondItem) {
        return firstItem.compareTo(secondItem) < 0;
    }
}

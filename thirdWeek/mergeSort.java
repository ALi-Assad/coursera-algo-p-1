package thirdWeek;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class mergeSort {
    public static void main(String[] args) {
        int[] array = StdIn.readAllInts();
        Integer[] newArray = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            Integer item = Integer.valueOf(array[i]);
            newArray[i] = item;
        }
        Integer[] aux = new Integer[newArray.length];
        sort(newArray, aux, 0, newArray.length - 1);

        StdOut.println("after sort: ");
        for (int i = 0; i < newArray.length; i++) {
            StdOut.println(newArray[i]);
        }
    }


    public static void merge(Comparable[] array, Comparable[] aux, int lo, int mid, int hi) {

        assert isSorted(array, lo, mid);
        assert isSorted(array, mid + 1, hi);

        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) array[k] = aux[j++];
            else if (j > hi) array[k] = aux[i++];
            else if (less(aux[j], aux[i])) array[k] = aux[j++];
            else array[k] = aux[i++];
        }

        assert isSorted(array, lo, hi);

    }

    public static void sort(Comparable[] array, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(array, aux, lo, mid);
        sort(array, aux, mid + 1, hi);
        if (!less(array[mid+1], array[mid])) return;
        merge(array, aux, lo, mid, hi);

    }

    private static boolean less(Comparable firstItem, Comparable secondItem) {
        return firstItem.compareTo(secondItem) < 0;
    }

    private static boolean isSorted(Comparable[] array, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            if (less(array[i + 1], array[i])) {
                return false;
            }
        }
        return true;
    }
}

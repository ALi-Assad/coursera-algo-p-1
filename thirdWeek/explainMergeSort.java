package thirdWeek;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class explainMergeSort {

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


    public static void merge(Comparable[] array, Comparable[] axu, int lo, int mid, int hi) {
        StdOut.println();
        StdOut.println("merge");
        StdOut.println();

        assert isSorted(array, lo, mid);
        assert isSorted(array, mid + 1, hi);

        for (int k = lo; k <= hi; k++) {
            axu[k] = array[k];
        }

        StdOut.println();
        StdOut.println("first array");
        for (int k = lo; k <= mid; k++) {
            StdOut.print(axu[k] + " ");
        }
        StdOut.println();
        StdOut.println("second array");
        for (int k = mid + 1; k <= hi; k++) {
            StdOut.print(axu[k] + " ");
        }
        StdOut.println();


        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) array[k] = axu[j++];
            else if (j > hi) array[k] = axu[i++];
            else if (less(axu[j], axu[i])) array[k] = axu[j++];
            else array[k] = axu[i++];
        }

        StdOut.println();
        StdOut.println("main array after merge");
        for (int k = 0; k <= hi; k++) {
            StdOut.print(array[k] + " ");
        }
        StdOut.println();

        assert isSorted(array, lo, hi);

    }

    public static void sort(Comparable[] array, Comparable[] aux, int lo, int hi) {
       // final int CUTOFF = 7;
        StdOut.println("---------------------------");
        StdOut.println();
        StdOut.println("sort");
        StdOut.println();
        StdOut.println("call: ");
        StdOut.println("target elements: ");
        for (int i = lo; i <= hi; i++) {
            StdOut.print(array[i]+ " ");
        }
        StdOut.println();
        StdOut.println("main array: ");
        for (int i = 0; i < array.length; i++) {
            StdOut.print(array[i]+ " ");
        }
        StdOut.println();
        StdOut.println("aux array: ");
        for (int i = 0; i < aux.length; i++) {
            StdOut.print(aux[i]+ " ");
        }
        StdOut.println();


         if (hi <= lo) {
           // Insertion.sort(array, lo, hi);
             StdOut.println("break");
            return;
        }
        StdOut.println("continued");
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

package thirdWeek.QuickSort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {


    public static void main(String[] args) {
        int[] array = StdIn.readAllInts();
        Integer[] newArray = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            Integer item = Integer.valueOf(array[i]);
            newArray[i] = item;
        }

        StdRandom.shuffle(newArray);

        sort(newArray, 0, newArray.length - 1);

        StdOut.println("after sort: ");
        for (int i = 0; i < newArray.length; i++) {
            StdOut.println(newArray[i]);
        }
    }

    public static void sort(Comparable[] a, int lo, int hi){

        if(hi <= lo) return;;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi){
        int i = lo, j = hi + 1;
        while (true){
            while (less(a[++i], a[lo]))
                if(i == hi)
                    break;

            while (less(a[lo],a[--j]))
                if(j == lo)
                    break;

            if(i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
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

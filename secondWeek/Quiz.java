package secondWeek;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Quiz {


    public static void main(String[] args) {
        int[] fArray = StdIn.readAllInts();
        int[] sArray = StdIn.readAllInts();

        Integer[] newFArray = new Integer[fArray.length];
        Integer[] newSArray = new Integer[sArray.length];
        StdOut.println(fArray.length + "-" + sArray.length);
        for (int i = 0; i < fArray.length; i++) {
            Integer fItem = Integer.valueOf(fArray[i]);
            newFArray[i] = fItem;

            Integer SItem = Integer.valueOf(sArray[i]);
            newSArray[i] = SItem;
        }

        sort(newFArray);
        sort(newSArray);

        if(permutation(newFArray, newSArray)){
            StdOut.println("True");
        }else {
            StdOut.println("false");
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

    private static boolean permutation(Integer[] newFArray, Integer[] newSArray){

        if(newFArray.length != newSArray.length){
           return false;
        }else {
            for (int i = 0 ; i < newFArray.length ; i++){
                if(newFArray[i].compareTo(newSArray[i]) != 0){
                    return false;
                }
            }
        }
        return true;
    }
}

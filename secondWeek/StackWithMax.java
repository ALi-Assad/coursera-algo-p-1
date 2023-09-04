package secondWeek;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

public class StackWithMax {

    private Integer[] itemsArray;
    private Integer n = 0;

    private Integer max = 0;

    private static final int PUSH_TYPE = 1;
    private static final int POP_TYPE = 0;

    StackWithMax() {
        itemsArray = new Integer[1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(Integer item) {
        if (n == itemsArray.length) resize(itemsArray.length * 2);
        itemsArray[n++] = item;
    }

    public Integer pop() {
        Integer item = itemsArray[--n];
        itemsArray[n] = null;
        if(n > 0 && (n == (itemsArray.length/4))) resize(itemsArray.length/2);
        return item;
    }

    public void print() {
        StdOut.println("Items:");
        for (int i = n - 1; i >= 0; i--) {
            StdOut.println(itemsArray[i]);
        }
    }

    public static void main(String[] args) {
        StackWithMax stackWithMaxClass = new StackWithMax();
        do {

            StdOut.println("Please inter operation type: 1 for push, 0 for pop");
            int type = StdIn.readInt();

            if (type == PUSH_TYPE) {
                StdOut.println("Please inter item to insert:");
                int item = StdIn.readInt();

                if(item > stackWithMaxClass.max){
                    stackWithMaxClass.max = item;
                }

                stackWithMaxClass.push(item);
            } else if (type == POP_TYPE) {
                Integer removedItem = stackWithMaxClass.pop();
                stackWithMaxClass.setMaxValue();
                StdOut.println("removedItem: " + removedItem);
            }

            stackWithMaxClass.print();
            StdOut.println();

            StdOut.println("max value: " + stackWithMaxClass.max);

            if (!StdIn.hasNextLine()) {
                return;
            }
        } while (StdIn.hasNextLine());
    }

    private void resize(int capacity) {
        Integer[] newArray = new Integer[capacity];

        for (int i = 0; i < n; i++) {
            newArray[i] = itemsArray[i];
        }
        itemsArray = newArray;
    }

    private void setMaxValue(){
        Integer[] newItemsArray = new Integer[n];
        System.arraycopy(itemsArray, 0, newItemsArray, 0, n);
        Arrays.sort(newItemsArray, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (o1 == null && o2 == null) {
                    return 0;
                }
                if (o1 == null) {
                    return 1;
                }
                if (o2 == null) {
                    return -1;
                }
                return o1.compareTo(o2);
            }});
        max = newItemsArray[n-1];
    }
}

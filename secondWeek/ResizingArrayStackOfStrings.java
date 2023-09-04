package secondWeek;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayStackOfStrings {

    private String[] itemsArray;
    private int n = 0;

    private static final int PUSH_TYPE = 1;
    private static final int POP_TYPE = 0;

    ResizingArrayStackOfStrings() {
        itemsArray = new String[1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(String item) {
        if (n == itemsArray.length) resize(itemsArray.length * 2);
        itemsArray[n++] = item;
        StdOut.println("array size after push:" + itemsArray.length);
    }

    public String pop() {
        String item = itemsArray[--n];
        itemsArray[n] = null;
       if(n > 0 && (n == (itemsArray.length/4))) resize(itemsArray.length/2);
        StdOut.println("array size after pop:" + itemsArray.length);
        return item;
    }

    public void print() {
        StdOut.println("Items:");
        for (int i = 0; i < n; i++) {
            StdOut.println(itemsArray[i]);
        }
    }

    public static void main(String[] args) {
        ResizingArrayStackOfStrings resizingArrayClass = new ResizingArrayStackOfStrings();
        do {

            StdOut.println("Please inter operation type: 1 for push, 0 for pop");
            int type = StdIn.readInt();

            if (type == PUSH_TYPE) {
                StdOut.println("Please inter item to insert:");
                String item = StdIn.readString();

                resizingArrayClass.push(item);
            } else if (type == POP_TYPE) {
                String removedItem = resizingArrayClass.pop();
                StdOut.println("removedItem: " + removedItem);
            }

            resizingArrayClass.print();
            StdOut.println();

            if (!StdIn.hasNextLine()) {
                return;
            }
        } while (StdIn.hasNextLine());
    }

    private void resize(int capacity) {
        String[] newArray = new String[capacity];

        for (int i = 0; i < n; i++) {
            newArray[i] = itemsArray[i];
        }
        itemsArray = newArray;
    }

}

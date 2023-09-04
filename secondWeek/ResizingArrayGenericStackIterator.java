package secondWeek;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ResizingArrayGenericStackIterator<Item> implements Iterable {


    private Item[] itemsArray;
    private int n = 0;

    private static final int PUSH_TYPE = 1;
    private static final int POP_TYPE = 0;


    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{
            private int i = n;

            public boolean hasNext(){
                return i > 0;
            }
            public Item next(){
                return itemsArray[--i];
            }
    }



    ResizingArrayGenericStackIterator() {
        itemsArray = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(Item item) {
        if (n == itemsArray.length) resize(itemsArray.length * 2);
        itemsArray[n++] = item;
        StdOut.println("array size after push:" + itemsArray.length);
    }

    public Item pop() {
        Item item = itemsArray[--n];
        itemsArray[n] = null;
        if (n > 0 && (n == (itemsArray.length / 4))) resize(itemsArray.length / 2);
        StdOut.println("array size after pop:" + itemsArray.length);
        return item;
    }

    public void print() {
        StdOut.println("Items:");
        for (int i = 0; i < n; i++) {
            StdOut.println(itemsArray[i]);
        }
    }

    private void resize(int capacity) {
        Item[] newArray = (Item[]) new Object[capacity];
        //itemsArray = (Item[]) new Object[1];

        for (int i = 0; i < n; i++) {
            newArray[i] = itemsArray[i];
        }
        itemsArray = newArray;
    }

    public static void main(String[] args) {
        //stringArrayStack();
        intArrayStack();
    }

    public static void stringArrayStack() {
        ResizingArrayGenericStackIterator<String> resizingArrayClass = new ResizingArrayGenericStackIterator<String>();
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

    public static void intArrayStack() {
        ResizingArrayGenericStackIterator<Integer> resizingArrayClass = new ResizingArrayGenericStackIterator<Integer>();
        do {

            StdOut.println("Please inter operation type: 1 for push, 0 for pop");
            int type = StdIn.readInt();

            if (type == PUSH_TYPE) {
                StdOut.println("Please inter item to insert:");
                Integer item = StdIn.readInt();

                resizingArrayClass.push(item);
            } else if (type == POP_TYPE) {
                Integer removedItem = resizingArrayClass.pop();
                StdOut.println("removedItem: " + removedItem);
            }

            resizingArrayClass.print();
            StdOut.println();

            if (!StdIn.hasNextLine()) {
                return;
            }
        } while (StdIn.hasNextLine());
    }
}

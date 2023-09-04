package secondWeek;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class GenericLinkedStackWithIterator<Item> implements Iterable {

    private Node first = null;
    private static final int PUSH_TYPE = 1;
    private static final int POP_TYPE = 0;


    public Iterator iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        public boolean hasNext() {
            return first == null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

    private class Node {
        Item item;
        Node next;
    }


    public boolean isEmpty() {
        return first == null;
    }


    public void push(Item item) {
        if (first == null) {
            first = new Node();
            first.item = item;
            first.next = null;
        } else {
            Node newNode = new Node();
            Node oldFirst = first;
            newNode.item = item;
            newNode.next = oldFirst;
            first = newNode;
        }
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        return item;
    }

    public void print() {
        Node f = first;
        while (f != null) {
            StdOut.println(f.item);
            f = f.next;
        }

    }

    public static void main(String[] args) {
        //stringLinkedStack();
        intLinkedStack();
    }

    public static void stringLinkedStack() {
        GenericLinkedStack<String> linkedClass = new GenericLinkedStack<String>();
        do {

            StdOut.println("Please inter operation type: 1 for push, 0 for pop");
            int type = StdIn.readInt();

            if (type == PUSH_TYPE) {
                StdOut.println("Please inter item to insert:");
                String item = StdIn.readString();

                linkedClass.push(item);
            } else if (type == POP_TYPE) {
                String removedItem = linkedClass.pop();
                StdOut.println("removedItem: " + removedItem);
            }

            linkedClass.print();
            StdOut.println();

            if (!StdIn.hasNextLine()) {
                return;
            }
        } while (StdIn.hasNextLine());
    }

    public static void intLinkedStack() {
        GenericLinkedStack<Integer> linkedClass = new GenericLinkedStack<Integer>();
        do {

            StdOut.println("Please inter operation type: 1 for push, 0 for pop");
            int type = StdIn.readInt();

            if (type == PUSH_TYPE) {
                StdOut.println("Please inter item to insert:");
                Integer item = StdIn.readInt();

                linkedClass.push(item);
            } else if (type == POP_TYPE) {
                Integer removedItem = linkedClass.pop();
                StdOut.println("removedItem: " + removedItem);
            }

            linkedClass.print();
            StdOut.println();

            if (!StdIn.hasNextLine()) {
                return;
            }
        } while (StdIn.hasNextLine());
    }

}

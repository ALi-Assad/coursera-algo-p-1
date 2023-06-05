import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinkedQueueOfStrings {

    Node first, last;

    private static final int PUSH_TYPE = 1;
    private static final int POP_TYPE = 0;


    public boolean isEmpty() {
        return first == null;
    }

    private class Node{
        String item;
        Node next;
    }

    private void enQueue(String item){
        Node oldLast = last;
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = null;
        last = newNode;
        if(isEmpty()) first = last;
        else oldLast.next = last;
    }

    private String deQueue(){
        Node oldFist = first;
        first = oldFist.next;
        if(isEmpty()) last = null;
        return oldFist.item;
    }

    public void print(){
        LinkedQueueOfStrings.Node f = first;
        StdOut.println("Items:");
        while (f != null){
            StdOut.println(f.item);
            f = f.next;
        }

    }


    public static void main(String[] args) {
        LinkedQueueOfStrings linkedClass = new LinkedQueueOfStrings();
        do {

            StdOut.println("Please inter operation type: 1 for push, 0 for pop");
            int type = StdIn.readInt();

            if(type == PUSH_TYPE){
                StdOut.println("Please inter item to insert:");
                String item = StdIn.readString();

                linkedClass.enQueue(item);
            }else if(type == POP_TYPE){
                String removedItem = linkedClass.deQueue();
                StdOut.println("removedItem: " + removedItem);
            }

            linkedClass.print();
            StdOut.println();

            if(!StdIn.hasNextLine()){
                return;
            }
        }while (StdIn.hasNextLine());
    }


}

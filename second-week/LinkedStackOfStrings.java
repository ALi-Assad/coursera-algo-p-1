import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinkedStackOfStrings {

    private Node first = null;
    private static final int PUSH_TYPE = 1;
    private static final int POP_TYPE = 0;

    private class Node {
        String item = "";
        Node next;
    }


    public boolean isEmpty() {
        return first == null;
    }


    public void push(String item) {
        if(first == null){
          first = new Node();
          first.item = item;
          first.next = null;
        }else {
            Node newNode = new Node();
            Node oldFirst = first;
            newNode.item = item;
            newNode.next = oldFirst;
            first = newNode;
        }
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    public void print(){
        Node f = first;
        while (f != null){
            StdOut.println(f.item);
            f = f.next;
        }

    }

    public static void main(String[] args) {
         LinkedStackOfStrings linkedClass = new LinkedStackOfStrings();
        do {

            StdOut.println("Please inter operation type: 1 for push, 0 for pop");
            int type = StdIn.readInt();

            if(type == PUSH_TYPE){
                StdOut.println("Please inter item to insert:");
                String item = StdIn.readString();

                linkedClass.push(item);
            }else if(type == POP_TYPE){
               String removedItem = linkedClass.pop();
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

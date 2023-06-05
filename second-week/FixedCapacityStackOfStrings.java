import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfStrings {

    private String[] itemsArray;
    private int n = 0;

    private static final int PUSH_TYPE = 1;
    private static final int POP_TYPE = 0;

    FixedCapacityStackOfStrings(int capacity){
        itemsArray = new String[capacity];
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public void push(String item){
        itemsArray[n++] = item;
    }

    public String pop(){
        String item = itemsArray[--n];
        itemsArray[n] = null;
       return item;
    }

    public void print(){
        StdOut.println("Items:");
        for (int i = 0 ; i < n ; i++) {
            StdOut.println(itemsArray[i]);
        }
    }

    public static void main(String[] args) {
        StdOut.println("Please inter the size of array:");
        int capacity = StdIn.readInt();
        FixedCapacityStackOfStrings fixedCapacityClass = new FixedCapacityStackOfStrings(capacity);
        do {

            StdOut.println("Please inter operation type: 1 for push, 0 for pop");
            int type = StdIn.readInt();

            if(type == PUSH_TYPE){
                StdOut.println("Please inter item to insert:");
                String item = StdIn.readString();

                fixedCapacityClass.push(item);
            }else if(type == POP_TYPE){
                String removedItem = fixedCapacityClass.pop();
                StdOut.println("removedItem: " + removedItem);
            }

            fixedCapacityClass.print();
            StdOut.println();

            if(!StdIn.hasNextLine()){
                return;
            }
        }while (StdIn.hasNextLine());
    }

}

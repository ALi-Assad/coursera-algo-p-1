package fourthWeek;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UnorderedMaxPQ <key extends Comparable<key>> {
    private key[] pq;
    private int n;

    private static final int INSERT_TYPE = 1;
    private static final int DELETE_MAX_TYPE = 0;

     public UnorderedMaxPQ(int capacity)
     {   pq = (key[]) new Comparable[capacity];}

     public boolean isEmpty(){
         return n == 0;
     }

    public void insert(key x)
    { pq[n++] = x; }

    public key delMax()
    {
        int max = 0;
        for (int i = 1; i < n; i++)
            if (less(pq[max], pq[i])) max = i;
        exch(max, n-1);
        return pq[--n];
    }

    public void print()
    {
        for (int i = 0; i < n; i++)
           StdOut.println(pq[i]);
    }

    private static boolean less(Comparable firstItem, Comparable secondItem) {
        return firstItem.compareTo(secondItem) < 0;
    }

    private void exch(int firstIndex, int secondIndex) {
        key swap = pq[firstIndex];
        pq[firstIndex] = pq[secondIndex];
        pq[secondIndex] = swap;
    }

    public static void main(String[] args) {
        UnorderedMaxPQ<Integer> maxPQ = new UnorderedMaxPQ<Integer>(10);
        do {

            StdOut.println("Please inter operation type: 1 for insert, 0 for delete max value");
            int type = StdIn.readInt();

            if(type == INSERT_TYPE){
                StdOut.println("Please inter item to insert:");
                Integer item = StdIn.readInt();

                maxPQ.insert(item);
            }else if(type == DELETE_MAX_TYPE){
                Integer removedItem = maxPQ.delMax();
                StdOut.println("deleted Item: " + removedItem);
            }

            maxPQ.print();
            StdOut.println();

            if(!StdIn.hasNextLine()){
                return;
            }
        }while (StdIn.hasNextLine());
    }

}

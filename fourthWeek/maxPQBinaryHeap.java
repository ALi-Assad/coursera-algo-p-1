package fourthWeek;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class maxPQBinaryHeap<key extends Comparable<key>> {
    int n;
    key[] pq;

    private static final int INSERT_TYPE = 1;
    private static final int DELETE_MAX_TYPE = 0;

    public maxPQBinaryHeap(int capacity) {
        pq = (key[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(key item) {
        pq[++n] = item;
        swim(n);
    }

    public key delMax() {
        key max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = null;
        return max;
    }

    public void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    public void sink(int k) {

        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(j, k);
            k = j;
        }
    }

    private boolean less(int firstItemKey, int secondItemKey) {
        return pq[firstItemKey].compareTo(pq[secondItemKey]) < 0;
    }

    private void exch(int firstKey, int secondKey) {
        key swap = pq[firstKey];
        pq[firstKey] = pq[secondKey];
        pq[secondKey] = swap;
    }

    public void print()
    {
        for (int i = 1; i <= n; i++)
            StdOut.println(pq[i]);
    }

    public static void main(String[] args) {
        maxPQBinaryHeap<Integer> maxPQ = new maxPQBinaryHeap<Integer>(10);
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

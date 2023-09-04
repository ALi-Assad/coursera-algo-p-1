package fourthWeek;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class symbolTablesWithBinary<Keys extends Comparable<Keys> , Values extends Comparable<Values>> {

    Keys[] keys;
    Values[] vals;

    public symbolTablesWithBinary(int capacity)
    {
        keys = (Keys[]) new Comparable[capacity];
        vals = (Values[]) new Comparable[capacity];
    }

    public static void main(String[] args) {
        symbolTablesWithBinary<Integer, Integer> obj = new symbolTablesWithBinary<Integer, Integer>(3);
        int n = StdIn.readInt();

        for (int i = 0; i < n; i++) {
            int item = StdIn.readInt();
            obj.vals[i] = item;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(obj.vals[i] + " ");
        }
    }
}

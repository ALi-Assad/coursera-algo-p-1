package thirdWeek.comparator;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Comparator;
import java.util.Random;

public class sort {


    public static void main(String[] args) {
        String[] names = new String[]{"s", "c", "j", "r", "a"};
        studentComparator[] objs = new studentComparator[5];
        for (int i = 0; i < 5; i++){
            int section = StdRandom.uniformInt(10);
            String name = names[i];
            studentComparator obj = new studentComparator(name, section);
            objs[i] = obj;
        }

        for (int i = 0; i < 5; i++){
            StdOut.println(objs[i].section);
        }

        StdOut.println("-----------------------");

        sort(objs, studentComparator.BY_SECTION);

        for (int i = 0; i < 5; i++){
            StdOut.println(objs[i].section);
        }

    }

    public static void sort(Object[] a, Comparator comparator)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
            for (int j = i; j > 0 && less(comparator, a[j], a[j-1]); j--)
                exch(a, j, j-1);
    }
    private static boolean less(Comparator c, Object v, Object w)
    { return c.compare(v, w) < 0;
    }
    private static void exch(Object[] a, int i, int j)
    { Object swap = a[i]; a[i] = a[j]; a[j] = swap; }
}

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class ThreeSum {

    public static int count(int[] a) {
        int n = a.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n ; j++ ){
                for (int k = j + 1; k < n ; k++){
                    if(a[i] + a[j] + a[k] == 0){
                        count++;
                    }
                }

        }
    }
        return count;
}

    public static void main(String[] args) {
        int[]  a = StdIn.readAllInts();

        Stopwatch stopwatch = new Stopwatch();
        StdOut.println(ThreeSum.count(a));
        double time = stopwatch.elapsedTime();
        StdOut.println(time);
    }
}

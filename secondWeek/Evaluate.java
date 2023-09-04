package secondWeek;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.lang.reflect.Array;

public class Evaluate {

    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (item.equals("(")) ;
            else if (item.equals("+")) ops.push(item);
            else if (item.equals("*")) ops.push(item);
            else if (item.equals(")")) {
                String op = ops.pop();
                if (op.equals("+")) vals.push(vals.pop() + vals.pop());
                if (op.equals("*")) vals.push(vals.pop() * vals.pop());
                if (op.equals("/")) vals.push(vals.pop() / vals.pop());
            } else vals.push(Double.parseDouble(item));
        }
        StdOut.println(vals.pop());
    }

}

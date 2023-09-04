package fifthWeek;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class redBlackBSTs<Key extends Comparable<Key>, Value>
{
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private class Node
    {
        private Key key;
        private Value val;
        private Node left, right;
        private int count;
        boolean color;
        public Node(Key key, Value val, boolean red)
        {
            this.key = key;
            this.val = val;
        }
    }
    private boolean isRed(Node x)
    {
        if (x == null) return false;
        return x.color == RED;
    }

    private Node rotateLeft(Node h)
    {
        assert isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h)
    {
        assert isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h)
    {
        assert !isRed(h);
        assert isRed(h.left);
        assert isRed(h.right);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }



    public int size()
    { return size(root); }
    private int size(Node x)
    {
        if (x == null) return 0;
        return x.count;
    }

    public void put(Key key, Value val)
    { root = put(root, key, val); }
    private Node put(Node h, Key key, Value val)
    {
        if (h == null) return new Node(key, val, RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else if (cmp == 0) h.val = val;
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        return h;
    }

    public int rank(Key key)
    { return rank(key, root); }
    private int rank(Key key, Node x)
    {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else if (cmp == 0) return size(x.left);
        return 0;
    }


    public Iterable<Key> keys()
    {
        Queue<Key> q = new Queue<Key>();
        inorder(root, q);
        return q;
    }
    private void inorder(Node x, Queue<Key> q)
    {
        if (x == null) return;
        inorder(x.left, q);
        q.enqueue(x.key);
        inorder(x.right, q);
    }



    public Key floor(Key key)
    {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }
    private Node floor(Node x, Key key)
    {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }


    public void print(){
        Node f = root;
        StdOut.println("greater:");
        while (f != null){
            StdOut.println(f.val);
            f = f.right;
        }

        Node n = root;
        StdOut.println("smaller:");
        while (n != null){
            StdOut.println(n.val);
            n = n.left;
        }

    }
    public Value get(Key key)
    {
        Node x = root;
        while (x != null)
        {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else if (cmp == 0) return x.val;
        }
        return null;
    }
    public void delete(Key key)
    { /* see next slides */ }
//    public Iterable<Key> iterator()
//    { /* see next slides */ }

    public static void main(String[] args) {
        redBlackBSTs<Integer, String> obj = new redBlackBSTs<Integer, String>();
        int n = StdIn.readInt();
        //Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            StdOut.print("inset the key: ");
            Integer key = StdIn.readInt();
            String value = "num: " + key;
            obj.put(key , value);
        }

        //StdOut.println(obj.get(3));
        obj.print();
        StdOut.print("inset key to floor: ");
        Integer fKey = StdIn.readInt();
        StdOut.println(obj.floor(fKey));
    }

}
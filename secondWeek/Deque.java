import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item>  {

    private static final int ADD_FIRST_TYPE = 1;
    private static final int ADD_LAST_TYPE = 2;
    private static final int REMOVE_FIRST_TYPE = 3;
    private static final int REMOVE_LAST_TYPE = 4;

    private Node<Item> first;
    private Node<Item> last;
    private int n;

    private static class Node<Item>
    {
        Node<Item> next;
        Node<Item> prev;
        Item item;
    }

    public Deque()
    {
        first = null;
        last = null;
        n = 0;
    }

    // is the deque empty?
    public boolean isEmpty()
    {
        return first == null;
    }

    // return the number of items on the deque
    public int size()
    {
        return n;
    }

    // add the item to the front
    public void addFirst(Item item)
    {
        if(item == null){
            throw new IllegalArgumentException("the item cannot be null");
        }
        Node<Item> newFirst = new Node<Item>();
        if(isEmpty()){
            newFirst.item = item;
            first = newFirst;
            last = newFirst;
        }else {
            Node<Item> oldFirst = first;
            newFirst.next = oldFirst;
            newFirst.prev = null;
            newFirst.item = item;
            oldFirst.prev = newFirst;
            first = newFirst;
        }
        n++;
    }

    // add the item to the back
    public void addLast(Item item)
    {
        if(item == null)
        {
            throw new IllegalArgumentException("the item cannot be null");
        }
        
        Node<Item>  newLast = new Node<Item>();
        if(isEmpty())
        {
            newLast.item = item;
            last = newLast;
            first = newLast;
        }else
        {
            Node<Item>  oldLast = last;
            newLast.next = null;
            newLast.prev = oldLast;
            newLast.item = item;
            oldLast.next = newLast;
            last = newLast;
        }
        n++;
    }

    // remove and return the item from the front
    public Item removeFirst()
    {
        if(first == null)
        {
            throw new NoSuchElementException("first element is empty");
        }
        Item item = first.item;
        if(n == 1)
        {
          first = null;
          last = null;
        }else
        {
          first = first.next;
          first.prev = null; 	
        }
        n--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast()
    {
        if(last == null)
        {
            throw new NoSuchElementException("last element is empty");
        }
        Item item = last.item;
        if(n == 1)
        {
          first = null;
          last = null;
        }else
        {
          last = last.prev;
          last.next = null;	
        }
        n--;
        return item;
    }

    private void print()
    {
        Iterator<Item> iterator = iterator();
        for (int i = 0; i < n; i++)
        {
            StdOut.println(iterator.next());
            if(!iterator.hasNext())
            {
                break;
            }
        }
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>
    {

        private Node<Item> current = first;

        public boolean hasNext()
        {
            return current != null;
        }


        public void remove()
        {
            throw new UnsupportedOperationException("operation unsupported");
        }

        public Item next()
        {
            if(current == null)
            {
                throw new NoSuchElementException("first element is empty");
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

    // unit testing (required)
    public static void main(String[] args)
    {
      Deque<Integer> deque = new Deque<Integer>();
        do {
            StdOut.println("Please inter operation type: 1 for add first, 2 for add last, 3 for remove first, 4 for remove last");
            int type = StdIn.readInt();
            if(type == ADD_FIRST_TYPE)
            {
                StdOut.println("Please inter item to insert at first:");
                Integer item = StdIn.readInt();
                deque.addFirst(item);
            }else if(type == ADD_LAST_TYPE)
            {
                StdOut.println("Please inter item to insert at last:");
                Integer item = StdIn.readInt();
                deque.addLast(item);
            }else if(type == REMOVE_FIRST_TYPE)
            {
                Integer removedItem = deque.removeFirst();
                StdOut.println("removedItem: " + removedItem);
            }else if(type == REMOVE_LAST_TYPE)
            {
                Integer removedItem = deque.removeLast();
                StdOut.println("removedItem: " + removedItem);
            }

            deque.print();
            StdOut.println();

            if(!StdIn.hasNextLine())
            {
                return;
            }
        }while (StdIn.hasNextLine());
    }

}

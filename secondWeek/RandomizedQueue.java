import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private static final int PUSH_TYPE = 1;
    private static final int POP_TYPE = 0;

    private Item[] itemsArray;
    private int n;
    public RandomizedQueue()
    {
        itemsArray = (Item[]) new Object[1];
        n = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty()
    {
        return n == 0;
    }

    // return the number of items on the randomized queue
    public int size()
    {
        return itemsArray.length;
    }

    // add the item
    public void enqueue(Item item)
    {
        if(item == null)
        {
            throw new IllegalArgumentException("the item cannot be null");
        }
       if(n == itemsArray.length) resize(2 * itemsArray.length);
       itemsArray[n++] = item;
    }

    // remove and return a random item
    public Item dequeue()
    {
        if(isEmpty())
        {
            throw new NoSuchElementException("array element is empty");
        }
        int p = StdRandom.uniform(n);
        Item item = itemsArray[p];
    	itemsArray[p] = itemsArray[n-1];
    	n--;
    	if (n > 0 && n == itemsArray.length / 4) resize(itemsArray.length / 2);
    	return item;   
    }
        

    // return a random item (but do not remove it)
    public Item sample()
    {
        if(isEmpty())
        {
            throw new NoSuchElementException("first element is empty");
        }
       return itemsArray[StdRandom.uniformInt(n)];
    }

    private void resize(int capacity)
    {
        Item[] newArray = (Item[]) new Object[capacity];

        for (int i = 0; i < n; i++)
        {
            newArray[i] = itemsArray[i];
        }
        itemsArray = newArray;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator()
    {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{
        private int i = n;

        public boolean hasNext()
        {
            return i > 0;
        }
        public void remove()
        {
            throw new UnsupportedOperationException("operation unsupported");
        }
        public Item next()
        {
            if(isEmpty())
            {
                throw new NoSuchElementException("no items remaining");
            }
            return itemsArray[--i];
        }
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

    // unit testing (required)
    public static void main(String[] args){
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<Integer>();
        do {
            StdOut.println("Please inter operation type: 1 for enqueue, 0 for dequeue");
            int type = StdIn.readInt();

            if(type == PUSH_TYPE)
            {
                StdOut.println("Please inter item to insert:");
                Integer item = StdIn.readInt();

                randomizedQueue.enqueue(item);
            }else if(type == POP_TYPE)
            {
                Integer removedItem = randomizedQueue.dequeue();
                StdOut.println("removedItem: " + removedItem);
            }

            randomizedQueue.print();

            if(!StdIn.hasNextLine())
            {
                return;
            }
        }while (StdIn.hasNextLine());
    }
}

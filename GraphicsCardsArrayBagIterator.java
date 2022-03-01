/** 
    * Class for impletmentation of Iterator.
    * Main purpose is to cycle through all objects contained within the object's
    * array for printing or other use cases.
    * @author Parker Talley
*/

package assignment2;

/**
    * Imported for iterator implementation.
*/ 
import java.util.Iterator;

public class GraphicsCardsArrayBagIterator implements Iterator<GraphicsCards> {
    private GraphicsCardsSortedArrayBag collection;
    private int current = 0;

    /**
        * Constructor for GraphicsCardsArrayBagIterator objects.
        * @param arrayBag object to pass through.
    */
    public GraphicsCardsArrayBagIterator(GraphicsCardsSortedArrayBag arrayBag) {
        collection = arrayBag;
        current = 0;
    }

    /**
        * Checks if there is a next value in the collection.
        * @return currect value if there is one in collection.
    */
    @Override
    public boolean hasNext() {
        return current < collection.size();
    }

    /**
        * Grabs current GraphicsCards to return and adds to count.
        * @return current GraphicsCards in the index loction.
    */
    @Override
    public GraphicsCards next() {
        GraphicsCards currentGraphicsCards = collection.grab(current);
        current++;
        return currentGraphicsCards;
    }

    /**
        * Required to implication, but not setup for this use.
    */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

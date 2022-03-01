/** 
    * Stores GraphicsCards object(s) in array that is sorted. 
    * The funtion included within GraphicsCardsSortedArrayBag are: add, size,
    * toString implementation, indexOf, remove, countOccurences, grab, total, 
    * replace, sameContents and iterator implementation.
    * @author Parker Talley
*/

package assignment2;

/**
    * Imported for iterator implementation.
*/ 
import java.util.Iterator;

public class GraphicsCardsSortedArrayBag implements Iterable<GraphicsCards> {

    // Stores the number of GrapicsCards in class.
    private int numGraphicsCards;

    /**
        * GraphicsCards (objects) are stored within colletion (Array).
    */
    private GraphicsCards graphicsCardsArray[];

    /**
        * Constructor for GraphicsCardsSortedArrayBag object(s).
        * @param SIZE is the size of the colletion of Graphics Cards.
    */
    public GraphicsCardsSortedArrayBag(int SIZE) {
        graphicsCardsArray = new GraphicsCards[SIZE];
    }

    /**
        * Create GraphicsCards object and add to graphicsCardsArray collection.
        * @param name is the name of the cards. Ex: GTX 1060
        * @param int  is the quanity of the cards. Ex: 20
    */
    public void add(String name, int quanity) {
        // Creates new graphics cards object.
        GraphicsCards newGraphicsCards = new GraphicsCards(name, quanity);
        // Checks if there is room in the array.
        if (numGraphicsCards < graphicsCardsArray.length) {
            // Adds object to end of array.
            graphicsCardsArray[numGraphicsCards] = newGraphicsCards;
            // Increase the count for objects in array.
            numGraphicsCards++;
            // Sorting algorithm - Bubble Sort.
            for (int i = 0; i < numGraphicsCards - 1; i++) {
                for (int j = 0; j < numGraphicsCards - i - 1; j++) {
                    if (graphicsCardsArray[j].compareTo(graphicsCardsArray[j + 
                        1]) == 1) {
                            GraphicsCards temp = graphicsCardsArray[j];
                            graphicsCardsArray[j] = graphicsCardsArray[j + 1];
                            graphicsCardsArray[j + 1] = temp;
                    }
                }
            }
        }
        // If there is not room in the array, print error message.
        else {
            System.out.println("GraphicsCardsArray is full!");
        }
    }

    /**
        * Getter for the total number of graphics cards in the array.
        * @return number of graphics cards in array.
    */
    public int size() {
        return numGraphicsCards;
    }

    /**
        * Override of the toSting to get representation of the array and its 
        * internal values.
        * @return GraphicsCards stored in array and their information in the form 
        * of a graph.
    */
    @Override
    public String toString() {
        String output = "Name\tQuanity\n---------------\n";
        for (int i = 0; i < numGraphicsCards; i++) {
            output += (graphicsCardsArray[i].getName() + "\t" + 
                graphicsCardsArray[i].getQuanity() + "\n");
        }
        return output;
    }

    /**
        * Determines what index a specific graphics card is located.
        * @param userIndexGraphicsCards the object to locate the index of.
        * @return returns the index of the object locations if found; if not found 
        * then returns -1.
    */
    public int indexOf(GraphicsCards userIndexGraphicsCards) {
        for (int i = 0; i < numGraphicsCards; i++) {
            if (graphicsCardsArray[i].equals(userIndexGraphicsCards)) {
                return i;
            }
        }
        return -1;
    }

    /**
        * Removes a GraphicsCards object from the array.
        * @param GraphicsCards is the object that is to be removed.
        * @return true: if object was successfully removed; false: if object was 
        * not found.
    */
    public boolean remove(GraphicsCards userRemoveGraphicsCards) {
        // Determines if the GraphicsCards object is in the array
        if (indexOf(userRemoveGraphicsCards) != -1) {
            /* Determines the index of the GraphicsCards object. Then moves all 
             * objects variables -1 index, overwriting the GraphicsCards object 
             * to be removed. */
            for (int i = indexOf(userRemoveGraphicsCards); i < numGraphicsCards 
                - 1; i++) {
                    graphicsCardsArray[i].setName(graphicsCardsArray[i + 
                        1].getName());
                    graphicsCardsArray[i].setQuanity(graphicsCardsArray[i + 
                        1].getQuanity());
            }
            // Reduce the count by one, since there is one less object.
            numGraphicsCards--;
            return true;
        }
        // If the GraphicsCards object is not in the array, returns false.
        else {
            return false;
        }
    }

    /**
        * Determines how many GraphicsCards object have the same name.
        * @param name is the name of the Graphics cards to search for 
        * occurences.
        * @return the number of times that the name was found.
    */
    public int countOccurrences(String name) {
        int count = 0;
        for (int i = 0; i < numGraphicsCards; i++) {
            if (name == graphicsCardsArray[i].getName()) {
                count += 1;
            }
        }
        return count;
    }

    /**
        * Determines if a object exist at a index in graphicsCardsArray. If a 
        * object does exist, return the name and quanity.
        * @param index the index of the object to grab the infromation from.
        * @return the information of the object if one exist, otherwise return 
        * null.
    */
    public GraphicsCards grab(int index) {
        if (index <= numGraphicsCards) {
            return graphicsCardsArray[index];
        }
        return null;
    }

    /**
        * Determines the total number of graphics cards quanity.
        * @return the total number of graphics cards quanity.
    */
    public int total() {
        int totalQuanity = 0;
        for (int i = 0; i < numGraphicsCards; i++) {
            totalQuanity += graphicsCardsArray[i].getQuanity();
        }
        return totalQuanity;
    }

    /**
        * Replaces the old graphics cards with new graphics cards.
        * @param oldGraphicsCards object to remove/replace.
        * @param newGraphicsCards object to add.
        * @return true: if successfully replaced; false: if object to replace 
        * not located.
    */
    public boolean replace(GraphicsCards oldGraphicsCards, 
        GraphicsCards newGraphicsCards) {
        /* This value MUST be stored in order for the function to work once the 
        replacement can start. */
        int oldGraphicsCardsIndex = indexOf(oldGraphicsCards);
            if (oldGraphicsCardsIndex != -1) {
                // Replaces oldGraphicsCards values with newGraphicsCards values
                graphicsCardsArray[oldGraphicsCardsIndex]
                    .setName(newGraphicsCards.getName());
                graphicsCardsArray[oldGraphicsCardsIndex]
                    .setQuanity(newGraphicsCards.getQuanity());
                // Sorting algorithm - Bubble Sort.
                for (int i = 0; i < numGraphicsCards - 1; i++) {
                    for (int j = 0; j < numGraphicsCards - i - 1; j++) {
                        if (graphicsCardsArray[j].compareTo(graphicsCardsArray[j
                            + 1]) == 1) {
                                GraphicsCards temp = graphicsCardsArray[j];
                                graphicsCardsArray[j] = graphicsCardsArray[j + 
                                    1];
                                graphicsCardsArray[j + 1] = temp;
                            }
                    }
                }
                return true;
            }
            return false;
        }
    
    /**
        * Determine if both GraphicsCardsSortedArrayBags' have the same 
        * contents.
        * @param compGraphicsCardsSortedArrayBag object to compare against.
        * @return true: if both have the same contents; false: if the contents 
        * are not the same.
    */
    public boolean sameContents(GraphicsCardsSortedArrayBag 
        compGraphicsCardsSortedArrayBag) {
        boolean determine1 = false;
        for(int i = 0; i < numGraphicsCards; i++) {
            for(int j = 0; j <= 
                compGraphicsCardsSortedArrayBag.numGraphicsCards; j++) {
                if(this.graphicsCardsArray[i]
                    .equals(compGraphicsCardsSortedArrayBag
                    .graphicsCardsArray[j]) == true) {
                        determine1 = true;
                        j = compGraphicsCardsSortedArrayBag.numGraphicsCards;
                    }
                }
                if(determine1 == false) {
                    return false;
                }
            determine1 = false; 
        }
        return true;
    }

    /**
        * Constructor for implementation of iterator.
        * @return new object of GraphicsCardsArrayBagIterator.
    */
    @Override
    public Iterator<GraphicsCards> iterator() {
        return new GraphicsCardsArrayBagIterator(this);
    }
}

/** 
    * Driver class for verifying objects/functions are working properly.
    * Classes being tested: GraphicsCards, GraphicsCardsSortedArrayBag and
    * GraphicsCardsArrayBagIterator.
    * @author Parker Talley
*/

package assignment2;

// Needed to test GraphicsCardsArrayBagIterator class.
import java.util.Iterator;

public class GraphicsCardsSortedArrayBagDriver {
    public static void main(String[] args) {
        /* GraphicsCards Class Test(s)
        Test GraphicsCards object(s) - constructor test */
        GraphicsCards testGraphicsCards1 = new GraphicsCards("GTX 1060", 5);
        GraphicsCards equalGraphicsCards1 = new GraphicsCards("GTX 1060", 5);
        GraphicsCards equalGraphicsCards2 = new GraphicsCards("GTX 1060", 5);
        GraphicsCards compareToGraphicsCards1 = new GraphicsCards("a", 1);
        GraphicsCards compareToGraphicsCards2 = new GraphicsCards("b", 1);
        
        // Method GraphicsCards setName/getName test
        testGraphicsCards1.setName("code1");
        assert testGraphicsCards1.getName().equals("code1") : 
            "Failure : GraphicsCards setName or getName";
        
        // Method GraphicsCards setQuanity/ge5 test
        testGraphicsCards1.setQuanity(1);
        assert testGraphicsCards1.getQuanity() == 1 : 
            "Failure : GraphicsCards setQuanity or getQuanity";

        // Method GraphicsCards toString test
        assert testGraphicsCards1.toString().equals("code1 1") : 
            "Failure : GraphicsCards toString";

        // Method GraphicsCards eqauls test
        assert equalGraphicsCards1.equals(equalGraphicsCards2) == true : 
            "Failure : GraphicsCards equals";

        // Method GraphicsCards equals test
        assert compareToGraphicsCards1.compareTo(compareToGraphicsCards2) == 
            -1 :"Failure : GraphicsCards compareTo";
        // End of GraphicsCards class test.

        /* GraphicsCardsArrayBag Class Test(s) 
        Test GraphicsCardsArrayBag objects - constructor test */
        GraphicsCardsSortedArrayBag testArrayBag1 = 
            new GraphicsCardsSortedArrayBag(5);
        GraphicsCardsSortedArrayBag testArrayBag2 = 
            new GraphicsCardsSortedArrayBag(1);
        GraphicsCardsSortedArrayBag testArrayBag3 = 
            new GraphicsCardsSortedArrayBag(2);
        GraphicsCardsSortedArrayBag testArrayBag4 =
            new GraphicsCardsSortedArrayBag(2);
        GraphicsCardsSortedArrayBag testArrayBag5 =
            new GraphicsCardsSortedArrayBag(2);
        GraphicsCardsSortedArrayBag testArrayBag6 =
            new GraphicsCardsSortedArrayBag(4);
        

        // Method GraphicsCardsSortedArrayBag add test
        testArrayBag1.add("A", 1);
        testArrayBag1.add("B", 2);
        testArrayBag1.add("C", 3);
        testArrayBag1.add("D", 4);
        testArrayBag1.add("E", 5);
        // Used for testArrayBag2; toString, remove
        testArrayBag2.add("A", 1);
        // Used for testArrayBag3; countOccurences, total, replace
        testArrayBag3.add("A", 1);
        testArrayBag3.add("A", 1);
        // Used for testArrayBag4; replace
        testArrayBag4.add("A", 1);
        testArrayBag4.add("B", 2);
        // Used for testArrayBag5; sameContents
        testArrayBag5.add("A", 1);
        testArrayBag5.add("B", 2);
        // Used for testArrayBag6; sameContents
        testArrayBag6.add("A", 1);
        testArrayBag6.add("A", 1);
        testArrayBag6.add("B", 2);
        testArrayBag6.add("B", 2);
        /* Checks if the program will fail if to many objects are added.
        Should print out statement 'GraphicsCardsArray is full!' */
        testArrayBag1.add("F", 6);
        

        // Method GraphicsCardsSortedArrayBag size test
        assert testArrayBag1.size() == 5 : "Failure GraphicsCardsSortedArrayBag : size";

        // Method GraphicsCardsSortedArrayBag toString test
        assert testArrayBag2.toString()
            .equals("Name\tQuanity\n---------------\nA\t1\n") : 
            "Failure GraphicsCardsSortedArrayBag : equals";

        // Method GraphicsCardsSortedArrayBag indexOf test
        assert testArrayBag1.indexOf(new 
            GraphicsCards("A", 1)) == 0 : 
            "Failure GraphicsCardsSortedArrayBag : indexOf";

        // Method GraphicsCardsSortedArrayBag remove
        testArrayBag2.remove(new GraphicsCards("A", 1));
        assert testArrayBag2.toString()
            .equals("Name\tQuanity\n---------------\n") : 
            "Failure GraphicsCardsSortedArrayBag : remove";

        // Method GraphicsCardsSortedArrayBag countOccurrences test
        assert testArrayBag3.countOccurrences("A") == 2 : 
            "Failure GraphicsCardsSortedArrayBag : countOccurrences";
        
        // Method GraphicsCardsSortedArrayBag grab test
        assert testArrayBag1.grab(0).equals(new GraphicsCards("A", 1)) : 
            "Failure GraphicsCardsSortedArrayBag : grab";

        // Methods GraphicsCardsSortedArrayBag total
        assert testArrayBag3.total() == 2 : 
            "Failure GraphicsCardsSortedArrayBag : total";

        // Methods GraphicsCardsSortedArrayBag replace
        assert testArrayBag4.replace(new GraphicsCards("A", 1), 
            new GraphicsCards("B", 2)) == true : 
            "Failure GraphicsCardsSortedArrayBag : replace";

        // Methods GraphicsCardsSortedArrayBag sameContents
        assert testArrayBag5.sameContents(testArrayBag6) == true : 
            "Failure GraphicsCardsSortedArrayBag : sameContents";

        // Methods GrpahicsCardsSortedArrayBag iterator print out
        Iterator<GraphicsCards> it = testArrayBag1.iterator();
        System.out.println("Iterator Print Out of testArrayBag1:");
        while(it.hasNext()) {
            System.out.println(it.next());
        }


        /* Once again, just some fun that I was having making 'real' objects,
        just not very useful for actaul testing. I choose graphics cards because
        there is a shortage of chip manufacturing and thought that a program 
        that could keep track of the GPUs in stock would be fun to make.
        GraphicsCardsSortedArrayBag Ampere = new GraphicsCardsSortedArrayBag(10);
        Ampere.add("RTX 3090", 30);
        Ampere.add("RTX 3060", 30);
        Ampere.add("RTX 3070", 30);
        Ampere.add("RTX 3080TI", 35);
        Ampere.add("RTX 3080TI", 30);

        GraphicsCardsSortedArrayBag Ampere1 = new GraphicsCardsSortedArrayBag(10);
        Ampere1.add("RTX 3090", 30);
        Ampere1.add("RTX 3060", 30);
        Ampere1.add("RTX 3070", 30);
        Ampere1.add("RTX 3080TI", 35);
        Ampere1.add("RTX 3080TI", 35);
        Ampere1.add("RTX 3080TI", 35);
        Ampere1.add("RTX 3080TI", 30);
        
        // toString representation
        System.out.println(Ampere);
        System.out.println(Ampere1);


        System.out.println(Ampere.sameContents(Ampere1)); */
    }
}

package combinations;

/**
 *
 * @author Fares Abu Ali
 */
public class TestMyModifiedComb {

    public static void main(String[] args) {

        CombinationsModified<String> c = new CombinationsModified<>();

        String[] ar = {"A", "B", "C", "D", "E"};
        //int r = 3;

        for (int i = 1; i <= ar.length; i++) {
            c.printCombination(ar, ar.length, i);
            System.out.println(c.arList);
            System.out.println(c.arList.size());
            c.arList.clear();
            System.out.println();
        }


    }// end main
}// end class

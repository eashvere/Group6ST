// This program uses the SearchTree class to construct a binary
// search tree of integers and printing out each element in level order.

import java.util.*;

public class SearchTreeClient {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        SearchTree<Integer> numbers = new SearchTree<Integer>();
        System.out.print("Next int (0 to quit)? ");
        int number = console.nextInt();
        while (number != 0) {
            numbers.add(number);
            System.out.print("Next int (0 to quit)? ");
            number = console.nextInt();
        }
        System.out.println("In order traversal: ");
        numbers.print();
        System.out.println();
        System.out.println("Level order traversal: ");
        numbers.printByLevel();
    }
}

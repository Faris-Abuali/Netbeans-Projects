/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 *
 * @author Fares Abu Ali
 */
public class TestTestTest {

    public static void main(String[] args) {

        AVLTree<Integer> tree = new AVLTree<>();

        tree.insertt(25);
        tree.insertt(20);

        tree.insertt(5);

        System.out.println("BFS Tree after inserting 25,20,5 :");
        tree.breadthFirstSearch();

        tree.insertt(34);
        System.out.println("BFS Tree after inserting 34 :");
        tree.breadthFirstSearch();

        tree.insertt(50);
        System.out.println("BFS Tree after inserting 50 :");
        tree.breadthFirstSearch();

        tree.insertt(30);
        System.out.println("BFS Tree after inserting 30 :");
        tree.breadthFirstSearch();

        tree.insertt(10);
        System.out.println("BFS Tree after inserting 10 :");
        tree.breadthFirstSearch();

        System.out.println("\nNow Remove:");

        tree.delete(34);
        System.out.println("BFS Tree after removing 34:");

        tree.breadthFirstSearch();

        tree.delete(30);
        System.out.println("BFS Tree after removing 30:");

        tree.breadthFirstSearch();

        tree.delete(50);
        System.out.println("BFS Tree after removing 50:");

        tree.breadthFirstSearch();

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class Test {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {

        BST tree = new BST();

//        tree.add(11);
//        tree.add(6);
//        tree.add(19);
//        tree.add(4);
//        tree.add(8);
//        tree.add(43);
//        tree.add(17);
//        tree.add(5);
//        tree.add(10);
//        tree.add(31);
//        tree.add(49);
        //System.out.println(tree.height());
        //System.out.println(tree.nodesCount());
        //System.out.println(tree.height());
        tree.insert(25);
        tree.insert(20);
        tree.insert(30);
        tree.insert(15);
        tree.insert(22);
        tree.insert(27);
        tree.insert(35);
        tree.insert(10);
        tree.insert(16);
        tree.insert(23);
        tree.insert(26);
//        tree.insert(28);
//        tree.insert(34);
//        tree.insert(40);

        //System.out.println(tree.getNodeWhoseElementIs(23).element);
        //tree.pathToNode(tree.getNodeWhoseElementIs(162));

        ArrayList<Node> a = tree.pathToElement(16);

        //System.out.println(a);
        
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i).element+" ");
        }


        // tree.breadthFirstSearch();
//
//       System.out.println(tree.findGrandParent(16).getElement());
//        System.out.println(tree.findParent(tree.findParent(16).getElement()).element);
//        System.out.println(tree.findGrandParent(20));
//        
//        
//       System.out.println(tree.checkIfCousins(20,30));
        //  System.out.println(tree.checkIfCousins(27, 35));
        //  System.out.println(tree.countOfLeaves());
//        System.out.println(tree.findGrandParent(26));
//        
//        System.out.println(tree.findGrandParent(34).equals(tree.findGrandParent(22)));
//        tree.remove(24);
//
//        tree.breadthFirstSearch();
        //---------------------------------------------Traversal------------------------------------
//        tree.inOrder();
//        tree.postOrder();
//        //------------------------ 
//
//        tree.breadthFirstSearch();// queue of nodes
//
//        tree.breadthFirstSearchButFromBottom();
//
//        tree.displayLevelOrder();
//        //------------------------ 
//
//        //------------------------ 
//        tree.depthFirstSearch();
//        tree.preOrder();
//        System.out.println(ANSI_CYAN + "Depth-first traversal is the same as preorder traversal" + ANSI_RESET);
//        //-------------Depth-first traversal is the same as preorder traversal-----
//
//        tree.displayTree();
        //System.out.println(tree.depth());
//////19, 23, 24, 33, 36, 39, 44, 46, 90, 95, 99, 103,
////tree.add(23);
////tree.add(19);
////tree.add(24);
////tree.add(39);
////tree.add(36);
////tree.add(99);
////tree.add(33);
////tree.add(90);
////tree.add(103);
////tree.add(46);
////tree.add(59);
////tree.add(44);
//        //System.out.println(tree.height());
//        //tree.displayTree();
////
////tree.add(8);
////tree.add(9);
////tree.add(2);
////tree.add(5);
////tree.add(3);
////tree.add(1);
////tree.add(33);
////tree.add(2);
////tree.add(1);
////tree.add(55);
////        System.out.print("In-Order Traversal:");
////        tree.inOrder();
////        System.out.print("Pre-Order Traversal:");
////        tree.preOrder();
////        System.out.print("Post-Order Traversal:");
////        tree.postOrder();
////
////        System.out.print("Breadth First Search Traversal(Level Order):");
////        tree.breadthFirstSearch();
//        //System.out.println(Arrays.toString(tree.BFS()));
//        // tree.BFS();
//        //tree.printLevelOrderBFS();
//        //System.out.println(tree.nodesCount());
//        //System.out.println("hright="+tree.height());
        //tree.printPyramid(3, 0, 6);
    }

}

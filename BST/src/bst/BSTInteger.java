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
public class BSTInteger {

    private Node root;

    public static class Node {

        public Node left, right;
        public int element;

        public Node(int element) {
            this.element = element;
            left = right = null;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public void setElement(int element) {
            this.element = element;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public int getElement() {
            return element;
        }

    }

    public BSTInteger() {

        this.root = null;

    }

    public BSTInteger(Integer[] ar) {

        this.root = null;

        for (int i = 0; i < ar.length; i++) {
            insertIbra(ar[i]);
        }

    }

    public void aMethod() {
        aMethod(root);

        printLevelLevelSeparately();
    }

    public void aMethod(Node node) {

        Node ol;

        if (node == null) {
            return;
        }

        aMethod(node.left);
        aMethod(node.right);

        ol = node.left;

        node.left = new Node(node.element);
        node.left.left = ol;
    }

    public void giveAllPaths() {

        ArrayList<Integer> ar = new ArrayList<>();
        giveAllPathsFromRootToLeaf(root, ar);
    }

    public ArrayList<Integer> giveAllPathsFromRootToLeaf(Node curRoot, ArrayList<Integer> ar) {

        if (curRoot != null) {

            ar.add(curRoot.element);

            if (curRoot.left == null && curRoot.right == null) {
                System.out.println(ar);
                ar.remove(ar.size() - 1);
            } else {

                ar = giveAllPathsFromRootToLeaf(curRoot.left, ar);

                ar = giveAllPathsFromRootToLeaf(curRoot.right, ar);

                ar.remove(ar.size() - 1);

            }

        }

        return ar;
    }

    public int height() {
        return height(root, 0) - 1;
    }

    private int height(Node currRoot, int h) {

        if (currRoot == null) {
            h = 0;
        } else {

            h = 1 + Math.max(height(currRoot.left, 0), height(currRoot.right, 0));

        }

        return h;

    }

    public void printLevelLevelSeparately() {

        for (int i = 0; i <= height(); i++) {
            printGivenLevel(root, i);
            System.out.println();
        }
    }

    public void printGivenLevel(Node curRoot, int level) {

        if (curRoot != null) {
            if (level == 0) {
                System.out.print(curRoot.element + " ");
            } else {
                printGivenLevel(curRoot.left, level - 1);
                printGivenLevel(curRoot.right, level - 1);
            }
        }
    }

    public void createCompleteBST() {
        createCompleteBST(root);
    }

    public void createCompleteBST(Node curRoot) {

        if (curRoot != null) {

            if (curRoot.left != null && curRoot.right != null) {

                if ((curRoot.right.element - curRoot.left.element) < curRoot.element) {

                    curRoot.left.setElement(curRoot.right.element - curRoot.element);

                } else if ((curRoot.right.element - curRoot.left.element) > curRoot.element) {
                    curRoot.right.setElement(curRoot.element + curRoot.left.element);
                }
            }// the node has 2 children
            else if (curRoot.right != null && curRoot.left == null) {
                insert(curRoot.right.element - curRoot.element);
            } else if (curRoot.left != null && curRoot.right == null) {
                insert(curRoot.element + curRoot.left.element);
            }

            createCompleteBST(curRoot.left);
            createCompleteBST(curRoot.right);

        }

    }

    public void breadthFirstSearch() {//queue

        MyQueue<Node> q = new MyQueue<>();

        if (root != null) {
            q.enqueue(root);
        }

        while (!q.isEmpty()) {

            Node currRoot = q.dequeue();

            System.out.print(currRoot.getElement() + " ");

            if (currRoot.left != null) {
                q.enqueue(currRoot.left);
            }

            if (currRoot.right != null) {
                q.enqueue(currRoot.right);
            }

        }

        System.out.println();
    }//end BFS

    public Node[] floorAndCeilOf(int key) {

        Node[] arNode = new Node[2];

        arNode[0] = new Node(Integer.MIN_VALUE);
        arNode[1] = new Node(Integer.MAX_VALUE);

        floorOf(key, arNode, root);
        ceilOf(key, arNode, root);

        return arNode;
    }

    public void floorOf(int key, Node[] arNode, Node curRoot) {

        if (curRoot != null) {

            if ((curRoot.element <= key) && (curRoot.element > arNode[0].getElement())) {
                arNode[0] = curRoot;
                floorOf(key, arNode, curRoot.right);
            } else {
                floorOf(key, arNode, curRoot.left);
                floorOf(key, arNode, curRoot.right);

            }

        }

    }

    public void ceilOf(int key, Node[] arNode, Node curRoot) {

        if (curRoot != null) {

            if (curRoot.element >= key && (curRoot.element < arNode[1].getElement())) {
                arNode[1] = curRoot;
                ceilOf(key, arNode, curRoot.left);

            } else {
                ceilOf(key, arNode, curRoot.left);
                ceilOf(key, arNode, curRoot.right);
            }
        }

    }

//    public void print(int k) {
//        
//        print(root, k);
//    }
//    int countt = 0;
//
//    public void print(Node root, int k) {
//        
//        if (root != null && countt <= k) {
//            print(root.right, k);
//            countt++;
//            if (countt == k) {
//                System.out.println(root.getElement());
//            }
//            
//            print(root.left, k);
//        }
//        
//    }
    public void insertIbra(int element) {
        if (root == null) {
            root = new Node(element);
        } else {
            Node currRoot = root;

            while (true) {

                if (element < currRoot.element) {

                    if (currRoot.left == null) {
                        currRoot.left = new Node(element);
                        break;
                    } else {
                        currRoot = currRoot.left;
                    }
                } else if (element > currRoot.element) {
                    if (currRoot.right == null) {
                        currRoot.right = new Node(element);
                        break;
                    } else {
                        currRoot = currRoot.right;
                    }
                }
            }// end while
        }
    }

    public boolean searchRec(int element) {
        return searchRec(element, root);
    }

    private boolean searchRec(int element, Node currRoot) {

        if (currRoot == null) {
            return false;
        } else if (element < currRoot.element) {
            return searchRec(element, currRoot.left);
        } else if (element > currRoot.element) {
            return searchRec(element, currRoot.right);
        } else {
            return true;
        }

    }

    public void insert(int data) {
        // first of all, check that the element to be added does not exist curremtly in the tree
        if (searchRec(data) == false) {
            root = insertRec(root, data);
        }
    }

    private Node insertRec(Node currRoot, int data) {

        if (currRoot == null) {
            currRoot = new Node(data);
        } else if (data < currRoot.element) {
            currRoot.left = insertRec(currRoot.left, data);
        } else {
            currRoot.right = insertRec(currRoot.right, data);
        }

        return currRoot;

    }

    public int sumOfAllNodes() {
        return sumOfAllNodes(root, 0);
    }

    private int sumOfAllNodes(Node currRoot, int sum) {

        if (currRoot != null) {
            sum = currRoot.element + sumOfAllNodes(currRoot.left, 0) + sumOfAllNodes(currRoot.right, 0);
        }

        return sum;
    }

    public ArrayList<Node> pathToElement(int element) {

        ArrayList<Node> arList = new ArrayList<>();

        if (searchRec(element) == true) {
            pathToElement(element, root, arList);
        }

        return arList;
    }

    private void pathToElement(int element, Node currRoot, ArrayList arList) {

        if (currRoot != null) {

            arList.add(currRoot);

            if (element < currRoot.element) {
                pathToElement(element, currRoot.left, arList);
            } else if (element > currRoot.element) {
                pathToElement(element, currRoot.right, arList);
            }
        }

    }

    public Node lowestCommonAncestor(int element1, int element2) {

        ArrayList pathToElement1 = pathToElement(element1);
        ArrayList pathToElement2 = pathToElement(element2);

        Node LCA = null; // lowestCommonAnsestor

        for (int i = pathToElement1.size() - 1; i >= 0; i--) {
            if (pathToElement2.contains(pathToElement1.get(i))) {
                LCA = (Node) pathToElement1.get(i);
                break;
            }
        }
        return LCA;
    }

    public Node searchAndGive(int element) {
        return searchAndGive(element, root);
    }

    //---------------------------------------------------------------------------------------------
    public Node searchAndGive(int element, Node currRoot) {

        if (currRoot != null) {

            if (element < currRoot.element) {
                return searchAndGive(element, currRoot.left);
            } else if (element > currRoot.element) {
                return searchAndGive(element, currRoot.right);
            } else {
                return currRoot;
            }

        }

        return null;
    }

    public Node[] giveTwoNodesWhoseSum(int sum) {

        Node[] n = new Node[2];
        n[0] = new Node(Integer.MAX_VALUE);
        n[1] = new Node(Integer.MAX_VALUE);

        return fafa(root, sum, n);
    }

    public Node[] fafa(Node curRoot, int sum, Node[] n) {

        n[0] = curRoot;

        if (curRoot != null) {

            Node temp = searchAndGive(sum - curRoot.element);
            if (temp != null) {
                n[1] = temp;
                return n;
            } else {

                n = fafa(curRoot.left, sum, n);

                n = fafa(curRoot.right, sum, n);

            }
        }
        return n;
    }

    //---------------------------------------------------------------------------------------------
//    public ArrayList<Integer> giveCommulativeArrayOf(ArrayList<Integer> arList) {
//
//        for (int i = 1; i < arList.size(); i++) {
//            arList.set(i, arList.get(i) + arList.get(i - 1));
//        }
//        return arList;
//    }
//
//    public void replaceEveryElementWithTheSumOfAllLargerElements() {
//
//        ArrayList<Integer> arList = new ArrayList<>();
//
//        arList = inOrderTreeToArray(root, arList);
//
//        ArrayList<Integer> arListCommu = giveCommulativeArrayOf(arList);
//
//        reFillTree(arListCommu, root);
//
//    }
//    private void reFillTree(ArrayList<Integer> arListCommu, Node curRoot) {
//
//        if (curRoot != null) {
//
//            reFillTree(arListCommu, curRoot.left);
//            curRoot.element= arListCommu.get(arListCommu.size()-1) - arListCommu.get(i);
//            reFillTree(arListCommu, curRoot.right);
//
//        }
//
//    }
//    public ArrayList<Integer> inOrderTreeToArray(Node curRoot, ArrayList<Integer> arList) {
//
//        if (curRoot != null) {
//
//            inOrderTreeToArray(curRoot.left, arList);
//            arList.add(curRoot.element);
//            inOrderTreeToArray(curRoot.right, arList);
//
//            return arList;
//
//        }
//        return null;
//    }
    //---------------------------------------------------------------------------------------------
//        BSTInteger tree = new BSTInteger(new Integer[]{30, 20, 40, 10, 25, 35, 50, 33, 45, 32});
    //tree.replaceEveryElementWithTheSumOfAllLargerElements();
//        System.out.println(tree.lowestCommonAncestor(25, 45).element);
//        System.out.println(tree.lowestCommonAncestor(40, 20).element);
//        System.out.println(tree.lowestCommonAncestor(25, 10).element);
//        System.out.println(tree.lowestCommonAncestor(25, 20).element);
//
//        System.out.println(tree.lowestCommonAncestor(45, 35).element);
//        BSTInteger tree = new BSTInteger(new Integer[]{3, 2, 4, 1, 6, 5, 10, 8, 30});
//
//        Node[] ar = tree.giveTwoNodesWhoseSum(4);
//        System.out.println(ar[0].element);
//        System.out.println(ar[1].element);
    //tree.print(5);
    //System.out.println(tree.sumOfAllNodes());
//        Node[] fc = tree.floorAndCeilOf(7);
//        System.out.println(fc[0].getElement());
//        System.out.println(fc[1].getElement());
    public static void main(String[] args) {
        BSTInteger tree = new BSTInteger(new Integer[]{5, 3, 9, 1, 4, 7, 12, 6, 8, 20,11});

        // tree.createCompleteBST();
        // tree.breadthFirstSearch();
        tree.giveAllPaths();
        //tree.printLevelLevelSeparately();
        // tree.breadthFirstSearch();

    }
}// end class

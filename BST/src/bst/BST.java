package bst;

import ArrayList_based.MyStackAL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author Fares Abu Ali
 */
public class BST< E extends Comparable<E>> {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    protected Node<E> root;

//    public static class Node<E extends Comparable<E>> {
//
//        public Node left, right;
//        public E element;
//
//        public Node(E element) {
//            this.element = element;
//            left = right = null;
//        }
//
//        public void setLeft(Node<E> left) {
//            this.left = left;
//        }
//
//        public void setRight(Node<E> right) {
//            this.right = right;
//        }
//
//        public void setElement(E element) {
//            this.element = element;
//        }
//
//        public Node<E> getLeft() {
//            return left;
//        }
//
//        public Node<E> getRight() {
//            return right;
//        }
//
//        public E getElement() {
//            return element;
//        }
//
//    }
    public BST() {

        this.root = null;

    }

    public BST(E[] objects) {

        this.root = null;

        for (int i = 0; i < objects.length; i++) {
            insert(objects[i]);
        }

    }

    public Node<E> getNodeWhoseElementIs(E element) {

        Node<E> n = null;

        if (searchRec(element) == true) {
            n = getNodeWhoseElementIs(root, element);
        }

        return n;
    }

    private Node<E> getNodeWhoseElementIs(Node<E> currRoot, E element) {

        if (element.compareTo(currRoot.element) < 0) {
            return getNodeWhoseElementIs(currRoot.left, element);
        } else if (element.compareTo(currRoot.element) > 0) {
            return getNodeWhoseElementIs(currRoot.right, element);

        } else {
            return currRoot;
        }

    }

//    public boolean search(E element) {
//
//        boolean flag = false;
//
//        Node<E> currRoot = root;
//
//        while (currRoot != null) {
//
//            if (element.compareTo(currRoot.element) < 0) {
//                currRoot = currRoot.left;
//            } else if (element.compareTo(currRoot.element) > 0) {
//                currRoot = currRoot.right;
//            } else {
//                flag = true;
//                break;
//            }
//
//        }
//
//        return flag;
//    }
    //-------------------------------------Search-------------------------------------------
    public boolean searchRec(E element) {
        return searchRec(element, root);
    }

    private boolean searchRec(E element, Node<E> currRoot) {

        if (currRoot == null) {
            return false;
        } else if (element.compareTo(currRoot.element) < 0) {
            return searchRec(element, currRoot.left);
        } else if (element.compareTo(currRoot.element) > 0) {
            return searchRec(element, currRoot.right);
        } else {
            return true;
        }

    }

    public Node<E> findGrandParent(E element) {

        if (searchRec(element) == false) {
            throw new RuntimeException("The element:" + element + " does NOT exist in the tree");
        }
        return findGrandParent(element, null, null, root);
    }

    private Node<E> findGrandParent(E element, Node<E> granparentRoot, Node<E> parentRoot, Node<E> currRoot) {

        if (element.compareTo(currRoot.element) < 0) {
            granparentRoot = findGrandParent(element, parentRoot, currRoot, currRoot.left);
        } else if (element.compareTo(currRoot.element) > 0) {
            granparentRoot = findGrandParent(element, parentRoot, currRoot, currRoot.right);
        }

        return granparentRoot;

    }

    public Node<E> findParent(E element) {

        if (searchRec(element) == false) {
            throw new RuntimeException("The element:" + element + " does NOT exist in the tree");
        }
        return findParent(element, null, root);
    }

    private Node<E> findParent(E element, Node<E> parentRoot, Node<E> currRoot) {

        if (element.compareTo(currRoot.element) < 0) {
            parentRoot = findParent(element, currRoot, currRoot.left);
        } else if (element.compareTo(currRoot.element) > 0) {
            parentRoot = findParent(element, currRoot, currRoot.right);
        }

        return parentRoot;

    }

    //----------------------------------------Check If Cousins receives elements--------------------------
    public boolean checkIfCousins(E element1, E element2) {

        boolean flag = false;

        Node<E> grandParentForElement1 = findGrandParent(element1);
        Node<E> grandParentForElement2 = findGrandParent(element2);

        Node<E> parentForElement1 = findParent(element1);
        Node<E> parentForElement2 = findParent(element2);

        if (parentForElement1 == null || parentForElement2 == null
                ||// then either the element is the root or
                grandParentForElement1 == null || grandParentForElement2 == null)// or it doesn't have a grandparent                                                                       // the element doesn't have a grandparent
        {
            flag = false;
        } else if (grandParentForElement1.equals(grandParentForElement2) && !(parentForElement1.equals(parentForElement2))) {
            flag = true;
        }

        return flag;

    }

    //----------------------------------------Check If Cousins receives 2Nodes--------------------------
    public boolean checkIfCousins(Node<E> node1, Node<E> node2) {

        boolean flag = false;

        if (node1 != null && node2 != null) {

            Node<E> grandParentForElement1 = findGrandParent(node1.getElement());
            Node<E> grandParentForElement2 = findGrandParent(node2.getElement());

            Node<E> parentForElement1 = findParent(node1.getElement());
            Node<E> parentForElement2 = findParent(node2.getElement());

            if (parentForElement1 == null || parentForElement2 == null
                    || // then either the node is the root or     
                    grandParentForElement1 == null || grandParentForElement2 == null)// or it doesn't have a grandparent                                                                       // the element doesn't have a grandparent
            {
                flag = false;
            } else if (grandParentForElement1.equals(grandParentForElement2) && !(parentForElement1.equals(parentForElement2))) {
                flag = true;
            }
        }

        return flag;

    }

    //--------------------------the best insertion method------------------------------------
    // try: new watch with f7
    public boolean insert(E data) {
        // first of all, check that the element to be added does not exist curremtly in the tree
        boolean flag = false;

        if (searchRec(data) == false) {
            root = insertRec(root, data);
            flag = true;
        }

        return flag;
    }

    private Node<E> insertRec(Node<E> currRoot, E data) {

        if (currRoot == null) {
            currRoot = new Node(data);
        } else if (data.compareTo(currRoot.element) < 0) {
            currRoot.left = insertRec(currRoot.left, data);
        } else {
            currRoot.right = insertRec(currRoot.right, data);
        }

        return currRoot;

    }

    //------------------------------------insert but returns boolean----------------------------------------
    public boolean insertBoolean(E element) {

        boolean flag = false;

        if (root == null) {
            root = new Node(element);
            flag = true; // the node was inserted successfully
        } else {// the tree is not empty

            Node<E> currRoot = root;

            while (true) {

                if (element.compareTo(currRoot.element) < 0) {

                    if (currRoot.left == null) {
                        currRoot.left = new Node(element);
                        flag = true;// the node was inserted successfully
                        break;
                    } else {
                        currRoot = currRoot.left;
                    }

                } else if (element.compareTo(currRoot.element) > 0) {

                    if (currRoot.right == null) {
                        currRoot.right = new Node(element);
                        flag = true;// the node was inserted successfully
                        break;
                    } else {

                        currRoot = currRoot.right;
                    }

                } else { // if the element is neither greater nor less than the currRoot.element
                    // then the element is duplicate, so we won't add ot to the tree
                    flag = false;
                    break;
                }

            }// end of while
        }// end of BIG else 

        return flag;

    }

    public boolean insertBooleanRec(E element) {

        boolean flag = false;

        if (root == null) {
            root = new Node(element);
            flag = true;
        } else {
            flag = addBooleanRec(element, root, false);
        }

        return flag;
    }

    private boolean addBooleanRec(E element, Node<E> currRoot, boolean flag) {

        if (element.compareTo(currRoot.element) < 0) {

            if (currRoot.left == null) {
                currRoot.left = new Node(element);
                flag = true;
            } else {
                flag = addBooleanRec(element, currRoot.left, flag);
            }
        }// end if left
        else if (element.compareTo(currRoot.element) > 0) {

            if (currRoot.right == null) {
                currRoot.right = new Node(element);
                flag = true;
            } else {
                flag = addBooleanRec(element, currRoot.right, flag);
            }
        }

        return flag;

    }// end method addRec

    //--------------------------------------------------------------------------------
    //----------------------------------Remove------------------------------------------
    // when the node to be deleted has a right subtree
    public Node<E> findMinimumOf(Node<E> currRoot) {

        if (currRoot.left == null) {
            return currRoot;
        }
        return findMinimumOf(currRoot.left);
    }

    public Node<E> remove(E value) {
        return root = removeRec(root, value);
    }

    private Node<E> removeRec(Node<E> currRoot, E data) {

        if (currRoot == null) {
            return null;
        } else if (data.compareTo(currRoot.element) < 0) {
            currRoot.left = removeRec(currRoot.left, data);
        } else if (data.compareTo(currRoot.element) > 0) {
            currRoot.right = removeRec(currRoot.right, data);
        } else if (currRoot.right == null) {
            return currRoot.left;
        } else if (currRoot.left == null) {
            return currRoot.right;
        } else {// then the node at which currRoot is pointing has 2 children
            currRoot.element = (E) findMinimumOf(currRoot.right).element;// find the minimum of the right subtree of currRoot (the successor), and put it as the currRoot.element
            currRoot.right = removeRec(currRoot.right, currRoot.element);//Now currRoot.element is the successor, we are
        }                                                                 // ready now to delete the successor(leaf)

        return currRoot;
    }

    //--------------------------Tree Traversal-----------------------------
    //--------------------------inOrder-----------------------------
    public void inOrder() {
        System.out.println(ANSI_GREEN + "In-Order Traversal: " + ANSI_RESET);
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node<E> currentRoot) {// left Root right

        if (currentRoot != null) {

            inOrderRec(currentRoot.left);
            System.out.print(currentRoot.element + " ");
            inOrderRec(currentRoot.right);
        }
    }

    //--------------------------------------------------------------
    //--------------------------preOrder-----------------------------
    public void preOrder() {
        System.out.println(ANSI_CYAN + "Pre-Order Traversal: " + ANSI_RESET);

        preOrderRec(root);
        System.out.println();

    }

    private void preOrderRec(Node<E> currentRoot) {

        if (currentRoot != null) {

            System.out.print(currentRoot.element + " ");
            preOrderRec(currentRoot.left);
            preOrderRec(currentRoot.right);
        }
    }

    //--------------------------------------------------------------
    //--------------------------postOrder-----------------------------
    public void postOrder() {
        System.out.println(ANSI_RED + "Post-Order Traversal: " + ANSI_RESET);

        postOrderRec(root);
        System.out.println();

    }

    private void postOrderRec(Node<E> currentRoot) {

        if (currentRoot != null) {

            postOrderRec(currentRoot.left);
            postOrderRec(currentRoot.right);
            System.out.print(currentRoot.element + " ");

        }
    }

    public void pathToNode(Node<E> targetNode) {

        if (targetNode != null) {

            System.out.println("Path To Node " + targetNode.element + ":");
            pathToNode(root, targetNode);
            System.out.println();
        } else {
            System.out.println("The Node does not exist");
        }
    }

    private void pathToNode(Node<E> currRoot, Node<E> targetNode) {

        if (currRoot != null) {

            if (targetNode.element.compareTo(currRoot.element) < 0) {
                System.out.print(currRoot.element + " ");
                pathToNode(currRoot.left, targetNode);
            } else if (targetNode.element.compareTo(currRoot.element) > 0) {
                System.out.print(currRoot.element + " ");
                pathToNode(currRoot.right, targetNode);
            } else {
                System.out.print(currRoot.element + " ");

            }

        }

    }

    public ArrayList<Node<E>> pathToElement(E element) {

        ArrayList<Node<E>> arList = new ArrayList<>();

        if (searchRec(element) == true) {
            pathToElement(element, root, arList);
        }

        return arList;
    }

    private void pathToElement(E element, Node<E> currRoot, ArrayList arList) {

        if (currRoot != null) {

            arList.add(currRoot);

            if (element.compareTo(currRoot.element) < 0) {
                pathToElement(element, currRoot.left, arList);
            } else if (element.compareTo(currRoot.element) > 0) {
                pathToElement(element, currRoot.right, arList);
            }
        }

    }

    //--------------------------------------------------------------
//    printLevelorder(tree)
//1) Create an empty queue q
//2) temp_node = root /*start from root*/
//3) Loop while temp_node is not NULL
//    a) print temp_node->data.
//    b) Enqueue temp_node’s children (first left then right children) to q
//    c) Dequeue a node from q and assign it’s value to temp_node
//   
//    
    public void breadthFirstSearch() {//queue

        System.out.println(ANSI_YELLOW + "Breadth-First-Traveral:" + ANSI_RESET);

        MyQueue<Node<E>> q = new MyQueue<>();

        if (root != null) {
            q.enqueue(root);
        }

        while (!q.isEmpty()) {

            Node<E> currRoot = q.dequeue();

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

    public void printGivenLevel(int level) {
        printGivenLevel(root, level);
    }

    public void printGivenLevel(Node curRoot, int level) {

        if (level == 0) {
            System.out.print(curRoot.element + " ");
        } else {
            printGivenLevel(curRoot.left, level - 1);
            printGivenLevel(curRoot.right, level - 1);
        }
    }

    public void printTreelInSpiralOrder() {

        int h = height(); // height of the tree=number of edges from the root to the farthes leaf
        boolean itr = false;

        for (int i = 0; i <= h; i++) {
            printTreeSpiralOrder(root, i, itr);

            itr = !itr;
        }
    }

    public void printTreeSpiralOrder(Node curRoot, int level, boolean itr) {

        if (curRoot != null) {
            if (level == 0) {
                System.out.print(curRoot.element + " ");
            } else {

                if (itr) {
                    printTreeSpiralOrder(curRoot.left, level - 1, itr);
                    printTreeSpiralOrder(curRoot.right, level - 1, itr);
                } else {
                    printTreeSpiralOrder(curRoot.right, level - 1, itr);
                    printTreeSpiralOrder(curRoot.left, level - 1, itr);
                }
            }
        }
    }
    
    

    public void depthFirstSearch() {//stack

        System.out.println(ANSI_CYAN + "Depth-First-Traveral:" + ANSI_RESET);

        MyStackAL<Node<E>> st = new MyStackAL();

        st.push(root);

        while (!st.isEmpty()) {

            Node<E> currRoot = st.pop();

            if (currRoot.right != null) {
                st.push(currRoot.right);
            }
            if (currRoot.left != null) {
                st.push(currRoot.left);
            }

            System.out.print(currRoot.element + " ");

        }

        System.out.println();

    }// end DFS

    public void breadthFirstSearchButFromBottom() {

        System.out.println(ANSI_YELLOW + "Breadth-First-Traveral BUT from bottom:" + ANSI_RESET);

        MyQueue<Node<E>> q = new MyQueue<>();

        Stack<Node<E>> st = new Stack<>();

        q.enqueue(root);

        Node<E> currRoot;

        while (!q.isEmpty()) {

            currRoot = q.dequeue();
            st.push(currRoot);

            //System.out.print(currRoot.getElement() + " ");
            if (currRoot.left != null) {
                q.enqueue(currRoot.left);
            }

            if (currRoot.right != null) {
                q.enqueue(currRoot.right);
            }

        }

        while (!st.isEmpty()) {
            System.out.print(st.pop().element + " ");
        }

    }

    public Object[] BFSArray() {

//        int ctr=0;
//        int level=0;//index
//        
//        if(ctr==Math.pow(2,level+1)-1)
//            level++;
//        
        int maxSize = (int) (Math.pow(2, height() + 1) - 1);

        Object[] ar = new Object[maxSize];

        MyQueue<Node<E>> q = new MyQueue<>();

        q.enqueue(root);
        int i = 0;

        while (!q.isEmpty() && i < maxSize) {

            Node<E> currRoot = q.dequeue();

            if (currRoot != null) {
                ar[i] = currRoot.element;

                q.enqueue(currRoot.left);

                q.enqueue(currRoot.right);
            } else {
                ar[i] = null;

            }

            i++;
        }

        //System.out.println(Arrays.toString(ar));
        return ar;

    }

    public void displayLevelOrder() {

        System.out.println(ANSI_YELLOW + "\nDisplay Each Level's Content: " + ANSI_RESET);
        Object[] ar = BFSArray();

        int level = 0;
        int index = 0;

        //System.out.println(Arrays.toString(ar));
        System.out.print("Level 0: ");

        while (index < ar.length) {

            if (index == Math.pow(2, level + 1) - 1) {
                level++;
                System.out.println();//newLine
                System.out.print("Level " + level + ": ");

            }

            System.out.print(ar[index] + " ");
            index++;
        }

        System.out.println("\n");
    }

    public void printLeadingSpaces(int height, int curLevel) {

        int numOfLeadingSpaces = (int) Math.pow(2, (height - curLevel));
        for (int i = 0; i < numOfLeadingSpaces; i++) {
            System.out.print(" ");
        }
    }

    public void displayTree() {

        System.out.println("\nRepresentaion of the tree:");

        Object[] ar = BFSArray();

        int height = height();

        int curLevel = 0;
        int index = 0;

        int numOfLeadingSpaces = (int) Math.pow(2, (height - curLevel)) - 1;

        printLeadingSpaces(height, curLevel);

        if (index == 0) {
            System.out.print(ar[index]);
            index++;
        }

        while (index < ar.length) {

            if (index == Math.pow(2, curLevel + 1) - 1) {// then continue in the same level

                System.out.println();

                printPyramid(height, curLevel, index, ar);

                curLevel++;

                printLeadingSpaces(height, curLevel);

                if (ar[index] != null) {
                    System.out.print(ar[index]);
                } else {
                    System.out.print(" ");
                }

            } else {
                // Notice that the #of spaces between the siblings = numOfLeadingSpaces for the previous level 
                int numOfpacesBetweenSiblings = (int) Math.pow(2, (height - curLevel + 1)) - 1;

                for (int i = 0; i < numOfpacesBetweenSiblings; i++) {
                    System.out.print(" ");
                }

                if (ar[index] != null) {
                    System.out.print(ar[index]);
                } else {
                    System.out.print(" ");
                }

            }

            index++;

        }//end while

        System.out.println();

    }

    public void printPyramid(int height, int level, int index, Object[] ar) {

        int numOfLines = height - level;

        int numOfLeadingSpaces = (int) Math.pow(2, (height - level)) - 1;

        int repeat = (int) Math.pow(2, level);

        for (int i = 0; i < numOfLines; i++) {

            int spacesBetweenTheLeftAndRighBranches = 2 * i + 1;

            //---------Leading Spaces------------------------------
            for (int r = 0; r < repeat; r++) {

                if (r == 0) {
                    for (int j = 0; j < numOfLeadingSpaces; j++) {
                        System.out.print(" ");
                    }
                }
                //--------------------------------------------

                System.out.print("/");

                //----------------spaces between /  and \ ---------------------
                for (int k = 0; k < spacesBetweenTheLeftAndRighBranches; k++) {
                    System.out.print(" ");
                }

                System.out.print("\\");

                int spacesBetweenEveryRepeat = 2 * (numOfLines - i) + 1;
                if (numOfLines == 1) {
                    spacesBetweenEveryRepeat = 1;
                }

                if (r != repeat - 1) {
                    for (int y = 0; y < spacesBetweenEveryRepeat; y++) {
                        System.out.print(" ");
                    }
                }

            }// end for r

            numOfLeadingSpaces--;

            System.out.println();
        }// end for i

    }

    public int nodesCount() {
        return nodesCount(root, 0);
    }

    private int nodesCount(Node<E> currRoot, int count) {

        if (currRoot == null) {
            count = 0;
        } else {
            count = 1 + nodesCount(currRoot.left, 0) + nodesCount(currRoot.right, 0);
        }

        return count;
    }

    public int countOfLeaves() {
        return countOfLeaves(root, 0);
    }

    private int countOfLeaves(Node<E> currRoot, int count) {

        if (currRoot == null) {
            count = 0;
        } else if (currRoot.left == null && currRoot.right == null) {
            count = 1;
        } else {
            count = count + countOfLeaves(currRoot.left, 0) + countOfLeaves(currRoot.right, 0);
        }

        return count;
    }

    public int numberOfLevels() {
        return height();
    }

    public int height() {
        return height(root, 0) - 1;
    }

    private int height(Node<E> currRoot, int h) {

        if (currRoot == null) {
            h = 0;
        } else {

            h = 1 + Math.max(height(currRoot.left, 0), height(currRoot.right, 0));

        }

        return h;

    }

    //------------------------------------------------------maxDepth = height ----------------------------------------
    public int maxDepth() {
        return maxDepth(root);
    }

    public int maxDepth(Node<E> curRoot) {

        if (curRoot == null) {
            return 0;
        }

        if (curRoot.left == null && curRoot.right == null) {
            return 0;
        }

        if (curRoot.left == null) {
            return 1 + maxDepth(curRoot.right);
        }

        if (curRoot.right == null) {
            return 1 + maxDepth(curRoot.left);
        }

        return 1 + Math.max(maxDepth(curRoot.left), maxDepth(curRoot.right));
    }

    public void printMaxDepthPath() {

        System.out.print("MaxDepthPath: ");
        printMaxDepthPath(root);
        System.out.println("");
    }

    public void printMaxDepthPath(Node<E> curRoot) {

        if (curRoot != null) {
            System.out.print(curRoot.element + " ");

            if (maxDepth(curRoot.left) > maxDepth(curRoot.right)) {
                printMaxDepthPath(curRoot.left);
            } else {
                printMaxDepthPath(curRoot.right);
            }

        }
    }
    //------------------------------------------------------maxDepth = height ----------------------------------------

    public int minDepth() {
        return minDepth(root);
    }

    public int minDepth(Node<E> curRoot) {

        if (curRoot == null) {
            return 0;
        }

        if (curRoot.left == null && curRoot.right == null) {
            return 0;
        }

        if (curRoot.left == null) {
            return 1 + minDepth(curRoot.right);
        }

        if (curRoot.right == null) {
            return 1 + minDepth(curRoot.left);
        }

        return 1 + Math.min(minDepth(curRoot.left), minDepth(curRoot.right));
    }

//    public void drawTree(){
//        
//        int depth=depth();
//        setLevels(root,0);
//        
//    }
    // utility functions
//    public int depth(){
//        return depth(root,0);
//        
//    }
//    
    private int depth(Node<E> currRoot, int depth) {
        if (currRoot == null) {
            return 0;
        }
        depth = 1 + Math.max(depth(currRoot.left, 0), depth(currRoot.right, 0));

        return depth;
    }

    public static void main(String[] args) {

        //BST<Integer> tree = new BST<>(new Integer[]{3, 2, 4, 1, 6, 5, 10, 8, 30});
        BST<Integer> tree = new BST<>(new Integer[]{30, 20, 40, 15, 25, 35, 45, 7, 16, 22, 26, 33, 36, 43, 46});
        //tree.printGivenLevel(2);
        tree.printTreelInSpiralOrder();

//        System.out.println(tree.minDepth());
//        System.out.println(tree.maxDepth());
//        tree.printMaxDepthPath();
    }

//    public void printLevelOrderBFS() {
//
//        MyQueue<Node<E>> q = new MyQueue<>();
//
//        q.enqueue(root);
//
//        int index = 0;
//        int level = 0;
//
//        while (!q.isEmpty()) {
//
//            int height = height();
//
//            for (int i = level; i < height; i++) {
//                System.out.print(" ");
//            }
//
//            Node<E> currRoot = q.dequeue();
//
//            if (currRoot != null) {
//
//                if (index == Math.pow(2, level + 1) - 1) {
//                    level++;
//                    System.out.println();// new Level, new Line
//                    for (int i = level; i < height; i++) {
//                        System.out.print(" ");
//                    }
//
//                }
//
//                System.out.print(currRoot.element + " ");
//                index++;
//
//                q.enqueue(currRoot.left);
//                q.enqueue(currRoot.right);
//
//            } else {
//
//                if (index == Math.pow(2, level + 1) - 1) {
//                    level++;
//                    System.out.println();// new Level, new Line
//                    for (int i = level; i < height; i++) {
//                        System.out.print(" ");
//                    }
//
//                }
//
//                System.out.print(" ");
//                index++;
//            }
//
//        }
//
////        int level = 0;
////
////        if (index == Math.pow(2, level + 1)) {
////            level++;
////            System.out.println("");
////        }
//    }
}// end class

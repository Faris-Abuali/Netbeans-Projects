package bst;

import java.util.ArrayList;

public class AVLTree<E extends Comparable<E>>/* extends BST<E>*/ {

    AVLTreeNode<E> root;

    public AVLTree() {

    }

    public AVLTree(E[] objects) {

        this.root = null;

        for (int i = 0; i < objects.length; i++) {
            insertt(objects[i]);
        }
    }

//    public static class AVLTreeNode<E extends Comparable<E>> extends Node<E> {
//
//        // contains the data fields element, left, and right, which are inherited by AVLTreeNode. 
//        // Thus, AVLTreeNode contains four data fields, 
//        public int height;
//
//        public AVLTreeNode(E element) {
//            super(element);
//        }
//
//    }//end inner class
    public AVLTreeNode createNewNode(E element) {
        return new AVLTreeNode(element);
    }

    public boolean insertt(E element) {

        boolean successful = insert(element);

        if (!successful) {// element is already in the tree
            return false;
        } else {// the element has been added successfully
            balancePath(element); // Balance from element to the root if necessary
        }

        return true;

    }

    private boolean insert(E data) {
        // first of all, check that the element to be added does not exist curremtly in the tree
        boolean flag = false;

        if (searchRec(data) == false) {
            root = insertRec(root, data);
            flag = true;
        }

        return flag;
    }

    private AVLTreeNode<E> insertRec(AVLTreeNode<E> currRoot, E data) {

        if (currRoot == null) {
            currRoot = new AVLTreeNode<>(data);
        } else if (data.compareTo(currRoot.element) < 0) {
            currRoot.left = insertRec(currRoot.left, data);
        } else {
            currRoot.right = insertRec(currRoot.right, data);
        }

        return currRoot;

    }

    public boolean searchRec(E element) {
        return searchRec(element, root);
    }

    private boolean searchRec(E element, AVLTreeNode<E> currRoot) {

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

    public ArrayList<AVLTreeNode<E>> pathToElementt(E element) {

        ArrayList<AVLTreeNode<E>> arList = new ArrayList<>();

        if (searchRec(element) == true) {
            pathToElementt(element, root, arList);
        }

        return arList;
    }

    private void pathToElementt(E element, AVLTreeNode<E> currRoot, ArrayList arList) {

        if (currRoot != null) {

            arList.add(currRoot);

            if (element.compareTo(currRoot.element) < 0) {
                pathToElementt(element, (AVLTreeNode<E>) currRoot.left, arList);
            } else if (element.compareTo(currRoot.element) > 0) {
                pathToElementt(element, (AVLTreeNode<E>) currRoot.right, arList);
            }
        }

    }

    private void balancePath(E element) {

        ArrayList<AVLTreeNode<E>> path = pathToElementt(element);

        for (int i = path.size() - 1; i >= 0; i--) {

            AVLTreeNode<E> A = path.get(i);

            updateHeight(A);
            AVLTreeNode<E> parentOfA = (A == root) ? null : path.get(i - 1);

            switch (balanceFactor(A)) {

                case -2:
                    if (balanceFactor(A.left) <= 0) {
                        balanceLL(A, parentOfA); // Perform LL rotation 
                    } else {
                        balanceLR(A, parentOfA); // Perform LR rotation
                    }
                    break;

                case +2:
                    if (balanceFactor(A.right) >= 0) {
                        balanceRR(A, parentOfA); // Perform RR rotation
                    } else {
                        balanceRL(A, parentOfA); // Perform RL rotation      
                    }
            }//end switch

        }// end for
    }

    private int balanceFactor(AVLTreeNode<E> node) {

        if (node.right == null) {// node has no right subtree
            return -node.height;
        } else if (node.left == null) { // node has no left subtree
            return +node.height;
        } else {
            return node.right.height - node.left.height;
        }
    }

    private void updateHeight(AVLTreeNode<E> node) {
        if (node.left == null && node.right == null) { // node is a leaf
            node.height = 0;
        } else if (node.left == null) {// node has no left subtree 

            node.height = 1 + node.right.height;
        } else if (node.right == null) { // node has no right subtree

            node.height = 1 + node.left.height;
        } else {
            node.height = 1 + Math.max(node.right.height, node.left.height);
        }
    }

    private void balanceLL(AVLTreeNode<E> A, AVLTreeNode<E> parentOfA) {

        AVLTreeNode<E> B = A.left; // A is left-heavy and B is left-heavy

        if (A == root) {
            root = B;
        } 
        else {

            if (parentOfA.left == A) {
                parentOfA.left = B;
            } else {
                parentOfA.right = B;
            }
        }

        A.left = B.right; // Make T2 the left subtree of A 
        B.right = A; // Make A the left child of B 
        updateHeight((AVLTreeNode<E>) A);
        updateHeight((AVLTreeNode<E>) B);
    }// end method

    private void balanceLR(AVLTreeNode<E> A, AVLTreeNode<E> parentOfA) {

        AVLTreeNode<E> B = A.left; // A is left-heavy    
        AVLTreeNode<E> C = B.right; // B is right-heavy 

        if (A == root) {
            root = C;
        } else {

            if (parentOfA.left == A) {
                parentOfA.left = C;
            } else {
                parentOfA.right = C;
            }
        }

        A.left = C.right; // Make T3 the left subtree of A 
        B.right = C.left; // Make T2 the right subtree of B
        C.left = B;
        C.right = A;

        updateHeight((AVLTreeNode<E>) A);
        updateHeight((AVLTreeNode<E>) B);
        updateHeight((AVLTreeNode<E>) C);

    }// end method

    private void balanceRR(AVLTreeNode<E> A, AVLTreeNode<E> parentOfA) {

        AVLTreeNode<E> B = A.right; // A is right-heavy and B is right-heavy

        if (A == root) {

            root = B;
        } else {

            if (parentOfA.left == A) {
                parentOfA.left = B;
            } else {

                parentOfA.right = B;
            }
        }

        A.right = B.left; // Make T2 the right subtree of A 
        B.left = A;
        updateHeight((AVLTreeNode<E>) A);
        updateHeight((AVLTreeNode<E>) B);

    }

    private void balanceRL(AVLTreeNode<E> A, AVLTreeNode<E> parentOfA) {

        AVLTreeNode<E> B = A.right; // A is right-heavy
        AVLTreeNode<E> C = B.left; // B is left-heavy

        if (A == root) {
            root = C;
        } else {

            if (parentOfA.left == A) {

                parentOfA.left = C;
            } else {
                parentOfA.right = C;
            }
        }

        A.right = C.left; // Make T2 the right subtree of A 
        B.left = C.right; // Make T3 the left subtree of B
        C.left = A;
        C.right = B;

        updateHeight((AVLTreeNode<E>) A);
        updateHeight((AVLTreeNode<E>) B);
        updateHeight((AVLTreeNode<E>) C);
    }

    public boolean delete(E element) {

        if (root == null) {
            return false;
        }

        AVLTreeNode<E> parent = null;
        AVLTreeNode<E> current = root;

        while (current != null) {

            if (element.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (element.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                break; // Element is in the tree pointed by current 
            }
        }// end while

        if (current == null) {
            return false; // Element is not in the tree 
        }

        // Case 1: current has no left children
        if (current.left == null) {

            if (parent == null) {
                root = current.right;
            } else {

                if (element.compareTo(parent.element) < 0) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }

                balancePath(parent.element);
            }
        } else {

            // Case 2: The current node has a left child 
            // Locate the rightmost node in the left subtree of the current node and also its parent 
            AVLTreeNode<E> parentOfRightMost = current;
            AVLTreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {

                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // Keep going to the right 
            }

            // Replace the element in current by the element in rightMost 
            current.element = rightMost.element;

            // Eliminate rightmost node
            if (parentOfRightMost.right == rightMost) {
                parentOfRightMost.right = rightMost.left;
            } else // Special case: parentOfRightMost is current
            {
                parentOfRightMost.left = rightMost.left;
            }

            // Balance the tree if necessary
            balancePath(parentOfRightMost.element);
        }
        return true; // Element inserted

    }

    //-------------------------------------------------------------------------------------------------------
//    public AVLTreeNode<E> findMinimumOf(AVLTreeNode<E> currRoot) {
//
//        if (currRoot.left == null) {
//            return currRoot;
//        }
//        return findMinimumOf(currRoot.left);
//    }
//
//    public AVLTreeNode<E> remove(E value) {
//        return root = removeRec(root, value, null);
//    }
//
//    private AVLTreeNode<E> removeRec(AVLTreeNode<E> currRoot, E data, AVLTreeNode<E> parentRoot) {
//
//        if (currRoot == null) {
//            return null;
//        } else if (data.compareTo(currRoot.element) < 0) {
//            currRoot.left = removeRec(currRoot.left, data, currRoot);
//        } else if (data.compareTo(currRoot.element) > 0) {
//            currRoot.right = removeRec(currRoot.right, data, currRoot);
//        } else if (currRoot.right == null) {
//            balancePath(parentRoot.element);
//
//            return currRoot.left;
//        } else if (currRoot.left == null) {
//            balancePath(parentRoot.element);
//
//            return currRoot.right;
//        } else {// then the node at which currRoot is pointing has 2 children
//            currRoot.element = (E) findMinimumOf(currRoot.right).element;// find the minimum of the right subtree of currRoot (the successor), and put it as the currRoot.element
//            balancePath(currRoot.element);
//            currRoot.right = removeRec(currRoot.right, currRoot.element, currRoot);
//        }
//
//        return currRoot;
//    }
    //-------------------------------------------------------------------------------------------------------

    public void breadthFirstSearch() {//queue

        System.out.println("Breadth-First-Traveral:");

        MyQueue<AVLTreeNode<E>> q = new MyQueue<>();

        if (root != null) {
            q.enqueue(root);
        }

        while (!q.isEmpty()) {

            AVLTreeNode<E> currRoot = q.dequeue();

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

    
    public static void main(String[] args) {
        AVLTree<Integer> tree=new AVLTree<>(new Integer[]{64,10,20,25,16,110,100,80});
        
        tree.breadthFirstSearch();
        
    }
}

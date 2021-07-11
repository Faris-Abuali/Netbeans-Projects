/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

import java.util.*;

public class TreeNode {

    public int idata;

    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    // variables needed to print the tree like a tree
    int depth = 0;
    int level = 0;
    int drawPos = 0;

    /**
     * ****** Functions to create a random binary search tree ********
     */
    public static int RANDOM_RANGE = 1000;

    public static TreeNode createRandomIntegerTree(int numNodes) {
        RANDOM_RANGE = 10 * numNodes;

        TreeNode root = new TreeNode();
        root.idata = (int) (Math.random() * RANDOM_RANGE);

        int treeSize = countNodes(root);
        while (treeSize < numNodes) {
            int count = numNodes - treeSize;
            while (count-- > 0) {
                root.insertInteger((int) (Math.random() * RANDOM_RANGE));
            }
            treeSize = countNodes(root);
        }
        return root;
    }

    // Inserts a given number into the BST
    void insertInteger(int data) {
        if (this.idata == data) {
            return;
        }
        if (this.idata < data) {
            if (this.right == null) {
                this.right = new TreeNode();
                this.right.idata = data;
                this.right.parent = this;
            } else {
                this.right.insertInteger(data);
            }
        } else {
            if (this.left == null) {
                this.left = new TreeNode();
                this.left.idata = data;
                this.left.parent = this;
            } else {
                this.left.insertInteger(data);
            }
        }
    }

    // Creates a random tree and prints it like a tree
    public static void main(String[] args) {
        TreeNode tree = new TreeNode();

        tree.insertInteger(11);
        tree.insertInteger(6);
        tree.insertInteger(19);
        tree.insertInteger(4);
        tree.insertInteger(8);
        tree.insertInteger(43);
        tree.insertInteger(17);
        tree.insertInteger(5);
        tree.insertInteger(10);
        tree.insertInteger(31);
        tree.insertInteger(49);
        
//        tree.insertInteger(23);
//        tree.insertInteger(19);
//        tree.insertInteger(24);
//        tree.insertInteger(39);
//        tree.insertInteger(36);
//        tree.insertInteger(99);
//        tree.insertInteger(33);
//        tree.insertInteger(90);
//        tree.insertInteger(103);
//        tree.insertInteger(46);
//        tree.insertInteger(59);
//        tree.insertInteger(44);
//        
        tree.inOrderInteger(", ");
        drawTree(tree);
    }

    /**
     * ********** Actual functions that print the tree like a tree
     * *******************
     */
    static void drawTree(TreeNode root) {

        System.out.println("\n\nLevel order traversal of tree:");
        int depth = depth(root);
        setLevels(root, 0);

        int depthChildCount[] = new int[depth + 1];

        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root.left);
        q.add(root.right);

        // draw root first
        root.drawPos = (int) Math.pow(2, depth - 1) * H_SPREAD;
        currDrawLevel = root.level;
        currSpaceCount = root.drawPos;
        System.out.print(getSpace(root.drawPos) + root.idata);

        while (!q.isEmpty()) {
            TreeNode ele = q.pollFirst();
            drawElement(ele, depthChildCount, depth, q);
            if (ele == null) {
                continue;
            }
            q.add(ele.left);
            q.add(ele.right);
        }
        System.out.println();
    }

    static int currDrawLevel = -1;
    static int currSpaceCount = -1;
    static final int H_SPREAD = 3;

    static void drawElement(TreeNode ele, int depthChildCount[], int depth, LinkedList<TreeNode> q) {
        if (ele == null) {
            return;
        }

        if (ele.level != currDrawLevel) {
            currDrawLevel = ele.level;
            currSpaceCount = 0;
            System.out.println();
            for (int i = 0; i < (depth - ele.level + 1); i++) {
                int drawn = 0;
                if (ele.parent.left != null) {
                    drawn = ele.parent.drawPos - 2 * i - 2;
                    System.out.print(getSpace(drawn) + "/");
                }
                if (ele.parent.right != null) {
                    int drawn2 = ele.parent.drawPos + 2 * i + 2;
                    System.out.print(getSpace(drawn2 - drawn) + "\\");
                    drawn = drawn2;
                }

                TreeNode doneParent = ele.parent;
                for (TreeNode sibling : q) {
                    if (sibling == null) {
                        continue;
                    }
                    if (sibling.parent == doneParent) {
                        continue;
                    }
                    doneParent = sibling.parent;
                    if (sibling.parent.left != null) {
                        int drawn2 = sibling.parent.drawPos - 2 * i - 2;
                        System.out.print(getSpace(drawn2 - drawn - 1) + "/");
                        drawn = drawn2;
                    }

                    if (sibling.parent.right != null) {
                        int drawn2 = sibling.parent.drawPos + 2 * i + 2;
                        System.out.print(getSpace(drawn2 - drawn - 1) + "\\");
                        drawn = drawn2;
                    }
                }
                System.out.println();
            }
        }
        int offset = 0;
        int numDigits = (int) Math.ceil(Math.log10(ele.idata));
        if (ele.parent.left == ele) {
            ele.drawPos = ele.parent.drawPos - H_SPREAD * (depth - currDrawLevel + 1);
            //offset = 2;
            offset += numDigits / 2;
        } else {
            ele.drawPos = ele.parent.drawPos + H_SPREAD * (depth - currDrawLevel + 1);
            //offset = -2;
            offset -= numDigits;
        }

        System.out.print(getSpace(ele.drawPos - currSpaceCount + offset) + ele.idata);
        currSpaceCount = ele.drawPos + numDigits / 2;
    }

    // Utility functions
    public void inOrderInteger(String sep) {
        if (left != null) {
            left.inOrderInteger(sep);
        }
        System.out.print(idata + sep);
        if (right != null) {
            right.inOrderInteger(sep);
        }
    }

    public static int depth(TreeNode n) {
        if (n == null) {
            return 0;
        }
        n.depth = 1 + Math.max(depth(n.left), depth(n.right));
        return n.depth;
    }

    public static int countNodes(TreeNode n) {
        if (n == null) {
            return 0;
        }
        return 1 + countNodes(n.left) + countNodes(n.right);
    }

    static void setLevels(TreeNode r, int level) {
        if (r == null) {
            return;
        }
        r.level = level;
        setLevels(r.left, level + 1);
        setLevels(r.right, level + 1);
    }

    static String getSpace(int i) {
        String s = "";
        while (i-- > 0) {
            s += " ";
        }
        return s;
    }

}

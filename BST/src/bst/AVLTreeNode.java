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
public class AVLTreeNode<E extends Comparable<E>> {

    // contains the data fields element, left, and right, which are inherited by AVLTreeNode. 
    // Thus, AVLTreeNode contains four data fields, 
    public int height;
    AVLTreeNode<E> left, right;
    E element;

    public AVLTreeNode(E element) {
        this.element = element;
    }

    public void setLeft(AVLTreeNode<E> left) {
        this.left = left;
    }

    public void setRight(AVLTreeNode<E> right) {
        this.right = right;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public AVLTreeNode<E> getLeft() {
        return left;
    }

    public AVLTreeNode<E> getRight() {
        return right;
    }

    public E getElement() {
        return element;
    }

}

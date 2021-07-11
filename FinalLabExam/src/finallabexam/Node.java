
package finallabexam;

/**
 *
 * @author Fares Abu Ali
 */


    
public class Node<E extends Comparable<E>> {
      
        public Node left, right;
        public E element;

        public Node(E element) {
            this.element = element;
            left = right = null;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        public E getElement() {
            return element;
        }

     
}

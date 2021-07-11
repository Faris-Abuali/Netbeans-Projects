package stackapplications;

/**
 *
 * @author Fares Abu Ali
 */
public class MyStack<E> {

    MyArrayList<E> list; // composition relationship

    public MyStack() {
        list = new MyArrayList<>();
    }

    public int getSize() {
        return list.getSize();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E element) {
        list.add(element);
    }

    public E pop() {
        return list.remove();
    }

    public E getPeek() {
        return list.get(getSize() - 1);
    }

    @Override
    public String toString() {

        String res = null;

        StringBuilder strB = new StringBuilder("\nStack Contents:-\n----------------\n");

        if(getSize()>0)
        strB.append(list.get(getSize() - 1) + " <---peek\n");

        for (int i = getSize() - 2; i >= 0; i--) {
            strB.append(list.get(i) + "\n");
        }

        strB.append("----------------");

        res = strB.toString();

        return res;

    }

    public MyStack<E> addInBetween(E element, int index, MyStack<E> st) {


        if(index<0 || index>st.getSize())
            throw new IndexOutOfBoundsException("Index= "+index+", but size="+st.getSize());
        
        MyStack<E> anotherStack = new MyStack<>();

        for (int i = 0; i < index; i++) {
            anotherStack.push(this.pop());
        }

        anotherStack.push(element);

        while (!this.isEmpty()) {
            anotherStack.push(this.pop());

        }

        anotherStack = anotherStack.reverseStack();

        return anotherStack;

    }

    public MyStack<E> reverseStack() {

        MyStack<E> temp = new MyStack<>();

        while (!this.isEmpty()) {
            temp.push(this.pop());
        }

        return temp;
    }

    public static void main(String[] args) {
        MyStack<String> m = new MyStack<>();

        m.push("2018");
        m.push("S");
        m.push("E");
        m.push("A");
        m.push("F");

        System.out.println(m);
        System.out.println("Size=" + m.getSize());

        System.out.println("Add in between: add R");
        m = m.addInBetween("R", 2, m);

        System.out.println(m);
        System.out.println("Size=" + m.getSize());

    }

}

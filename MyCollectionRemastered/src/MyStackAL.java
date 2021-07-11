


/**
 *
 * @author Fares Abu Ali
 */
public class MyStackAL<E> {

    MyArrayList<E> list; // composition relationship

    public MyStackAL() {
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

        strB.append(list.get(getSize() - 1) + " <---peek\n");

        for (int i = getSize() - 2; i >= 0; i--) {
            strB.append(list.get(i) + "\n");
        }

        strB.append("----------------");

        res = strB.toString();

        return res;

    }

    public MyStackAL<E> addInBetween(E element, int index, MyStackAL<E> st) {


        if(index<0 || index>st.getSize())
            throw new IndexOutOfBoundsException("Index= "+index+", but size="+st.getSize());
        
        MyStackAL<E> anotherStack = new MyStackAL<>();

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

    public MyStackAL<E> reverseStack() {

        MyStackAL<E> temp = new MyStackAL<>();

        while (!this.isEmpty()) {
            temp.push(this.pop());
        }

        return temp;
    }
    
    
  

    public static void main(String[] args) {
        MyStackAL<String> m = new MyStackAL<>();

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

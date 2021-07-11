package firstdatastructureseptoct;

/**
 *
 * @author Fares Abu Ali
 */
public class QueueUsingOneStack<E> {

    MyStack<E> st = new MyStack<>();

    public QueueUsingOneStack() {
    }

    public int getSize() {
        return st.getSize();
    }

    public void enqueu(E element) {
        st.push(element);
    }

    
    public E dequeue(){
        return funRec(null);
    }
    
    public E funRec(E save) {

        if (getSize() == 1) {
            return st.pop();
        }
        if(getSize()==0){
            return null;
        }

        E x = st.pop();
        save=funRec(save);
        st.push(x);
        return save;

    }

    public String toString() {
       
        return st.toString();
    }

    public static void main(String[] args) {

        QueueUsingOneStack q = new QueueUsingOneStack();
        q.enqueu(1);
        q.enqueu(2);
        q.enqueu(3);
        q.enqueu(4);

        System.out.println(q);
        q.dequeue();
        System.out.println(q);
    }

}

package sort;

import java.util.ArrayList;

/**
 *
 * @author Fares Abu Ali
 */
public class PriorityQueueMin implements MyPriorityQueue {

    public int heapSize;
    public ArrayList<Integer> arlist;

    public PriorityQueueMin() {

        arlist = new ArrayList();
        heapSize = 0;

    }

    @Override
    public int parentIndexOf(int index) {

        return (index - 1) / 2;

    }

    @Override
    public int leftChildIndexOf(int index) {
        return 2 * index + 1;
    }

    @Override
    public int rightChildIndexOf(int index) {
        return 2 * index + 2;
    }

    @Override
    public void insert(int key) {

        decreaseKey(key, heapSize);
        heapSize++;

    }

    @Override
    public void increaseKey(int key, int index) {// when I increase a key, I have to compare the new key with its parents

        arlist.set(index, key);

        heapifyMin(arlist, index);

    }

    @Override
    public int remove() {

        int itemToBeRemoved = arlist.get(0);

        arlist.remove(0);
        heapSize--;

        heapifyMin(arlist, 0);

        return itemToBeRemoved;
    }

    @Override
    public void decreaseKey(int key, int index) {// when I decrease a key, I have to compare the key with its children

        if (index == heapSize) {// then we want to add a new element
            arlist.add(key);
        } else {// then we just want to update an existent key
            arlist.set(index, key);
        }

        while (index > 0 && parentIndexOf(index) >= 0 && arlist.get(index) < arlist.get(parentIndexOf(index))) {
            swap(parentIndexOf(index), index);
            index = parentIndexOf(index);
        }

    }

    public void heapifyMin(ArrayList<Integer> ar, int parentIndex) {

        //System.out.println(Arrays.toString(ar));
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        int minIndex = parentIndex; // initial value

        if (leftChildIndex <= heapSize - 1 && ar.get(leftChildIndex) < ar.get(minIndex)) {

            minIndex = leftChildIndex;
        }
        if (rightChildIndex <= heapSize - 1 && ar.get(rightChildIndex) < ar.get(minIndex)) {
            minIndex = rightChildIndex;
        }

        if (minIndex != parentIndex) {// this means that one of there's a child larger than the parent, so the parent will be changed
            swap(parentIndex, minIndex);
            heapifyMin(ar, minIndex);// again invoke the function for the new parent
        }
    }

    @Override
    public void swap(int i, int j) {
        int temp = arlist.get(i);
        arlist.set(i, arlist.get(j));
        arlist.set(j, temp);
    }

    @Override
    public String toString() {
        return arlist.toString();
    }

    public boolean isEmpty() {
        return arlist.size() == 0;
    }

    public static void main(String[] args) {

        PriorityQueueMin pqm = new PriorityQueueMin();

        System.out.println("Inserting elements: 11,6,30,43,53,4: ");

        pqm.insert(11);
        System.out.println(pqm);
        pqm.insert(6);
        System.out.println(pqm);

        pqm.insert(30);
        System.out.println(pqm);
        pqm.insert(43);
        System.out.println(pqm);

        pqm.insert(35);
        System.out.println(pqm);

        pqm.insert(4);
        System.out.println(pqm);

        System.out.println("Now: start emptying the min priority queue");
        while (!pqm.isEmpty()) {
            System.out.println(pqm.remove());
        }

        //pqm.decreaseKey(3, 2);
//        pqm.increaseKey(37,2);
//        
//        
//        System.out.println(pqm);
        //System.out.println(pqm);
//        System.out.println("Remove "+pqm.remove());
//                System.out.println(pqm);
        //pqm.increaseKey(60,1);// increase 35 to 60
        //pqm.decreaseKey(13, 1);// increase 35 to 60
    }
}

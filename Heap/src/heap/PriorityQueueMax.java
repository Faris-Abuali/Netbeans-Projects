package heap;

// @author Fares Abu Ali
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Priority queue is a type of queue in which every element has a key associated to it and the queue
returns the element according to these keys, unlike the traditional queue which works on first come first serve basis.
 */
//1.Every item has a priority associated with it.
//2.An element with high priority is dequeued before an element with low priority.
//3.If two elements have the same priority, they are served according to their order in the queue.
//insert(item, priority): Inserts an item with given priority. O(log n)
//getHighestPriority(): Returns the highest priority item. O(1)
//deleteHighestPriority(): Removes the highest priority item. O(log n)
// Increase/Decrease key → To increase or decrease key of any element in the queue.
public class PriorityQueueMax implements MyPriorityQueue {

    public int heapSize;
    public ArrayList<Integer> arlist;

    public PriorityQueueMax() {

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

        increaseKey(key, heapSize);
        heapSize++;

    }

    @Override
    public void increaseKey(int key, int index) {// when I increase a key, I have to compare the new key with its parents

        if (index == heapSize) {// then we want to add a new element
            arlist.add(key);
        } else {// then we just want to update an existent key
            arlist.set(index, key);
        }

        while (index > 0 && parentIndexOf(index) >= 0 && arlist.get(parentIndexOf(index)) < arlist.get(index)) {

            swap(parentIndexOf(index), index);
            index = parentIndexOf(index);
        }

    }

    @Override
    public int remove() {

        int itemToBeRemoved = arlist.get(0);

        arlist.remove(0);
        heapSize--;

        //heapifyMax(arlist, 0);
        buildMaxHeap(arlist);

        return itemToBeRemoved;
    }

    @Override
    public void decreaseKey(int key, int index) {// when I decrease a key, I have to compare the key with its children

        arlist.set(index, key);

        heapifyMax(arlist, index);

    }

    public void heapifyMax(ArrayList<Integer> ar, int parentIndex) {

        //System.out.println(Arrays.toString(ar));
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        int maxIndex = parentIndex; // initial value

        if (leftChildIndex <= heapSize - 1 && ar.get(leftChildIndex) > ar.get(maxIndex)) {

            maxIndex = leftChildIndex;
        }
        if (rightChildIndex <= heapSize - 1 && ar.get(rightChildIndex) > ar.get(maxIndex)) {
            maxIndex = rightChildIndex;
        }

        if (maxIndex != parentIndex) {// this means that one of there's a child larger than the parent, so the parent will be changed
            swap(parentIndex, maxIndex);
            heapifyMax(ar, maxIndex);// again invoke the function for the new parent
        }
    }

    public void buildMaxHeap(ArrayList<Integer> ar) {

        for (int i = (heapSize - 1) / 2; i >= 0; i--) {// i statrts from the index of the last parent in the tree
            System.out.println("i = " + i);
            heapifyMax(ar, i);
            System.out.println("------------------------------------");
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

        PriorityQueueMax pqm = new PriorityQueueMax();

        System.out.println("Inserting elements: 11,6,30,43,58: ");
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

        pqm.insert(58);
        System.out.println(pqm);

        System.out.println("Now: start emptying the MAX priority queue");
        while (!pqm.isEmpty()) {
            System.out.println(pqm.remove());
        }

        //pqm.increaseKey(60,1);// increase 35 to 60
//        pqm.decreaseKey(13, 1);// increase 35 to 60
//
//        System.out.println(pqm);
//        System.out.println("Remove " + pqm.remove());
//
//        System.out.println(pqm);
//
//        System.out.println("Remove " + pqm.remove());
//
//        System.out.println(pqm);
//
////
//        System.out.println("Remove " + pqm.remove());
////        
//        System.out.println(pqm);
//
//        System.out.println("Remove " + pqm.remove());
////        
//        System.out.println(pqm);
//
//        System.out.println("Remove " + pqm.remove());
////        
//        System.out.println(pqm);
//
//        System.out.println("Remove " + pqm.remove());
////        
//        System.out.println(pqm);
//        pqm.insert(7);
//        pqm.insert(6);
//        pqm.insert(2);
//        pqm.insert(9);
//        pqm.insert(1);
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//        pq.add(20);
//        System.out.println(pq);
//        pq.add(15);
//        System.out.println(pq);
//        pq.add(30);
//        System.out.println(pq);
        //pq.add(100);
//        while(!pq.isEmpty()){
//            System.out.println(pq.poll());
//        }
    }

}// end class

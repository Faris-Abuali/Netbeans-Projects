package main;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        PC pc = new PC();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    synchronized (this) {

                        while (pc.i.get() < pc.list.size()) {

                            int current = pc.list.get(PC.i.get());
                            while (current % 2 == 1) {
                                wait();
                            }
                            //pc.printList();
                            System.out.println(current);
                            PC.i.set(PC.i.incrementAndGet());
                            notifyAll();
//                            int current = pc.list.get(PC.i);
//
//                            while (current % 2 != 1) {
//                                wait();
//                            }
//
//                                System.out.println(current);
//                                pc.i++;
//                            
//                            notifyAll();

                        }
                    }

                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        //Create consumer thread
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    synchronized (this) {

                        while (pc.i.get() < pc.list.size()) {

                            int current = pc.list.get(PC.i.get());
                            while (current % 2 == 0) {
                                wait();
                            }
                            //pc.printList();
                            System.out.println(current);
                            PC.i.set(PC.i.incrementAndGet());

                            notifyAll();
//                            int current = pc.list.get(PC.i);
//
//                            while (current % 2 != 1) {
//                                wait();
//                            }
//
//                                System.out.println(current);
//                                pc.i++;
//                            
//                            notifyAll();

                        }
                    }

                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // start both threads        
        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }

    public static class PC {

        static LinkedList<Integer> list = new LinkedList<>();
        static AtomicInteger i = new AtomicInteger(0);

        public PC() {

            list.add(1);
            list.add(2);
            list.add(5);
            list.add(3);
            list.add(4);
            list.add(10);

        }

        public void printList() throws InterruptedException {

            while (true) {

                synchronized (this) {

                    int currentInt = list.get(i.get());

                    System.out.println("by Thread:" + Thread.currentThread().getName() + "    " + currentInt);
                    i.set(i.incrementAndGet());

                }
            }

        }
    }

}

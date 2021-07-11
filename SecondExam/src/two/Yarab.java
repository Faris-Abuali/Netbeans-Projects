/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package two;

/**
 *
 * @author Fares Abu Ali
 */
public class Yarab {

    public static void main(String[] args) {
        AA a = new BB();
        BB b = new BB();
        ((AA) b).print();//A
        ((BB) a).print();//B

        a = b;

        a.print();//A

        b = (BB) a;
        b.print();//B
    }

}

class AA {

    public static void print() {
        System.out.println("A");

    }
}

class BB extends AA {

    public static void print() {
        System.out.println("B");

    }

}

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
public interface Anonymous {

    public int getValue();

}

class Outer {

    private int data = 15;

    public static void main(String[] args) {
        Anonymous inner = new Anonymous() {
            int data = 5;

            @Override
            public int getValue() {
                return data;
            }

            public int getData() {
                return data;
            }
        };
        Outer outer = new Outer();
       // System.out.println(inner.getValue() + inner.getData() + outer.data);
    }
}

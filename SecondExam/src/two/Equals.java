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
public class Equals {

}

class Circles {

    double radius;

    public Circles() {
    }

    public Circles(double radius) {
        this.radius = radius;
    }

    public static void main(String[] args) {

        Object circle1 = new Circles();
        Object circle2 = new Circles();
        System.out.println(circle1.equals(circle2));

    }

    @Override
    public boolean equals(Object o) {
        return (this.radius == ((Circles) o).radius);
    }
}

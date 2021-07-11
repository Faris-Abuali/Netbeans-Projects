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
abstract class Shape {

    public abstract double getArea();

}

class Square extends Shape {

    double side;

    public Square() {

    }

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        System.out.println("area of square of side: " + side + " = ");
        return side * side;
    }
}

class Triangle extends Shape {

    double base, height;

    public Triangle() {

    }

    public Triangle(double base, double height) {
        this.height = height;
        this.base = base;
    }

    @Override
    public double getArea() {
        System.out.println("area of triangle of base:" + base + "and height:" + height + " = ");

        return (1.0 / 2) * base * height;
    }
}

class Circle extends Shape {

    double radius;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        System.out.println("area of circle of radius:" + radius + " = ");
        return Math.PI * radius * radius;
    }

}

class Main {

    public static void main(String[] args) {
        Shape[] sh = new Shape[3];

        sh[0] = new Circle(3.4);
        sh[1] = new Triangle(2, 3);
        sh[2] = new Square(5);

        for (Shape currentShape : sh) {

            if (currentShape instanceof Circle) {
                System.out.println(((Circle) currentShape).getArea());
            } else if (currentShape instanceof Triangle) {
                System.out.println(((Triangle) currentShape).getArea());
            } else if (currentShape instanceof Square) {
                System.out.println(((Square) currentShape).getArea());
            }
        }
    }

}

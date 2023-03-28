public class Main {

    public static void main(String[] args) {
        Shape s1 = new Circle(1);
        Shape s2 = new Rectangle(1,1);
        Shape s3 = new Triangle(1,1);
        Shape s4 = new Trapezoid(1,1,1);
        shapeTest.countArea(s1);
        shapeTest.countArea(s2);
        shapeTest.countArea(s3);
        shapeTest.countArea(s4);
        System.out.println(shapeTest.area);
    }

}
class shapeTest {
    static double area = 0;
    static void countArea(Shape shape) {
        area += shape.getArea();
    }
}
abstract class Shape {
    abstract double getArea();
}
class Circle extends Shape {
    double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    double getArea() {
        return Math.PI * r * r;
    }
}
class Rectangle extends Shape {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double getArea() {
        return width * height;
    }
}
class Triangle extends Shape {
    double a;
    double b;

    public Triangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    double getArea() {
        return 0.5 * a * b;
    }
}
class Trapezoid extends Shape {
    double a;
    double b;
    double h;

    public Trapezoid(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    @Override
    double getArea() {
        return 0.5 * h * (a + b);
    }
}

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Circle s1 = new Circle(scanner.nextDouble());
        Rectangle s2 = new Rectangle(scanner.nextDouble(), scanner.nextDouble());
        Triangle s3 = new Triangle(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
        Trazpoid s4 = new Trazpoid(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
        double area = 0;
        area += s1.getArea();
        area += s2.getArea();
        area += s3.getArea();
        area += s4.getArea();
        System.out.printf("%.4f", area);
    }

}
abstract class Shape {
    abstract double getArea();
}
class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        if (radius <= 0) return 0;
        return radius * radius * Math.PI;
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
        if (width <= 0 || height <= 0) {
            return 0;
        }
        return width * height;
    }
}
class Triangle extends Shape {
    double a;
    double b;
    double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double getArea() {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 0;
        }
        if (a + b <= c || b + c <= a || a + c <= b) {
            return 0;
        }
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
class Trazpoid extends Shape {
    double a;
    double b;
    double h;

    public Trazpoid(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    @Override
    double getArea() {
        if (a <= 0 || b <= 0 || h <= 0) {
            return 0;
        }
        return (a + b) * h / 2;
    }
}
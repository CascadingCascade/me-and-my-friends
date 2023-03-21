
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("please input(0-2):");
            int type = s.nextInt();
            switch (type) {
                case 0 -> {
                    System.exit(0);
                }
                case 1 -> {
                    double cx = s.nextDouble(),
                            cy = s.nextDouble(),
                            cr = s.nextDouble();
                    Circle circle = new Circle();
                    circle.x = cx;
                    circle.y = cy;
                    circle.r = cr;
                    circle.display();
                }
                case 2 -> {
                    double cx = s.nextDouble(),
                            cy = s.nextDouble(),
                            cr = s.nextDouble(),
                            ch = s.nextDouble();
                    Cylinder cylinder = new Cylinder();
                    cylinder.x = cx;
                    cylinder.y = cy;
                    cylinder.h = ch;
                    cylinder.r = cr;
                    cylinder.display();
                }
            }
        }

        }
}
class Point {
    protected double x, y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
class Circle extends Point {
    protected double r;

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double area() {
        return r * r * Math.PI;
    }
    public void display() {
        System.out.printf("(%.1f,%.1f);%.1f;%.2f\n", x, y, r, area());
    }
}
class Cylinder extends Circle {
    protected double h;

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }
    public double volume() {
        return area() * h;
    }
    public void display() {
        System.out.printf("(%.1f,%.1f);%.1f;%.2f;%.1f;%.4f\n", x, y, r, area(), h, volume());
    }
}
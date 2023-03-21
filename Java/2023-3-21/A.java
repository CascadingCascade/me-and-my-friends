import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double sx = s.nextDouble(), sy = s.nextDouble();
        double w = s.nextDouble(), h = s.nextDouble();
        plainRect rect = new plainRect(w, h, sx, sy);
        double px = s.nextDouble(), py = s.nextDouble();
        System.out.printf("%.4f %.2f ",rect.area(), rect.perimeter());
        if (rect.isInside(px, py)) {
            System.out.println("In");
        } else {
            System.out.println("Out");
        }
        }
}
class Rectangle {
    double width = 10;
    double height = 10;
    public Rectangle(){}
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    double area() {return width * height;}
    double perimeter() {return 2 * width + 2 * height;}
}
class plainRect extends Rectangle {
    double startX = 0;
    double startY = 0;
    public plainRect(){}
    public plainRect(double width, double height, double startX, double startY) {
        super(width, height);
        this.startX = startX;
        this.startY = startY;
    }

    boolean isInside(double x,double y)
    {
        return (startX <= x && (startX + width) >= x) && (startY >= y && (startY - height) <= y);
    }
}

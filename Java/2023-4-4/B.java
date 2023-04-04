import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        if (type == 1) {
            Gym g = new Gym();
            System.out.printf("%.3f", g.getAVG(scanner));
        } else {
            School sc = new School();
            System.out.printf("%.3f",sc.getAVG(scanner));
        }
    }

}
interface ComputeAverage {
    double getAVG(Scanner scanner);
}
class Gym implements ComputeAverage {
    @Override
    public double getAVG(Scanner scanner) {
        ArrayList<Double> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            list.add(scanner.nextDouble());
        }
        list.sort(Double::compareTo);
        double total = 0;
        for (int i = 1; i < 9; i++) {
            total += list.get(i);
        }
        return total / 8;
    }
}
class School implements ComputeAverage {
    @Override
    public double getAVG(Scanner scanner) {
        ArrayList<Double> list = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            scanner.next();
            list.add(scanner.nextDouble());
        }
        double total = 0;
        for (Double d:
             list) {
            total += d;
        }
        return total / n;
    }
}
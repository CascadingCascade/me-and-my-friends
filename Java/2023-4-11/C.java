import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String in = "";
        try {
            in = reader.nextLine();
        } catch (Exception ignored) {
        }
        String[] types = in.split(" ");
        ArrayList<type> list = new ArrayList<>();
        for (String s:
             types) {
            String[] t = s.split(":");
            list.add(new type(t[0], Integer.parseInt(t[1])));
        }
        ArrayList<order> orders = new ArrayList<>();
        while (reader.hasNextLine()) {
            try {
                in = reader.nextLine();
            } catch (Exception ignored) {
                break;
            }

            String[] info = in.split(" ");
            orders.add(new order(info[0], Double.parseDouble(info[1]), Double.parseDouble(info[2])));
        }
        double sum = 0;
        ArrayList<String> invals = new ArrayList<>();
        ArrayList<order> vals = new ArrayList<>();
        for (order o:
             orders) {
            int p = 0;
            boolean f = false;
            for (type t:
                 list) {
                if (t.name.equals(o.name)) {
                    f = true;
                    p = t.cost;
                    break;
                }
            }
            if (!f) {
                invals.add(o.name);
            } else {
                vals.add(o);
                sum += p * o.l * o.w;
                o.p = p * o.l * o.w;
            }
        }
        for (String s:
             invals) {
            System.out.println("type " + s + " not exists");
        }
        for (order o:
             vals) {
            System.out.printf("%s %.1f %.1f %.1f\n",o.name, o.l, o.w, o.p);
        }
        System.out.printf("%d %.1f",vals.size(), sum);
    }

}
class type {
    String name;
    int cost;

    public type(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}
class order {
    String name;
    double l;
    double w;
    double p;
    public order(String name, double l, double w) {
        this.name = name;
        this.l = l;
        this.w = w;
    }
}
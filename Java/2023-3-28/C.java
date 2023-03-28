
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int capacity = n;
        ArrayDeque<person> queue = new ArrayDeque<>();
        while (true) {
            n= s.nextInt();
            switch (n) {
                case 0 -> {
                    System.exit(0);
                }
                case 1 -> {
                    String str = s.next();person p;
                    if (str.equals("a")) {
                        p = new person(s.next(), s.next());

                    } else {
                        p = new teacher(s.next(), s.next(), s.next());
                    }
                    if (queue.size() >= capacity) {
                        System.out.println("queue is full,operation failed");
                        continue;
                    }
                    queue.add(p);
                }
                case 2 -> {
                    if (queue.isEmpty()) {
                        System.out.println("queue is empty,operation failed");
                        continue;
                    }
                    System.out.println(queue.removeFirst());
                }
                case 3 -> {
                    String key = s.next();
                    boolean f = false;
                    for (person p:
                         queue) {
                        if (p.name.equals(key)) {
                            System.out.println(p);
                            f = true;
                        }

                    }
                    if (!f) System.out.println("no found");
                }
                case 4 -> {
                    System.out.println(queue.size());
                    break;
                }
            }

        }
    }

}
class person {
    String number;
    String name;

    public person(String number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return number + ',' + name;
    }

}
class teacher extends person {
    String loc;

    public teacher(String number, String name, String loc) {
        super(number, name);
        this.loc = loc;
    }

    @Override
    public String toString() {
        return super.toString() + ',' + loc;
    }
}

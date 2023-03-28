import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<student> list = new ArrayList<>(100);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(new engstu(s.next(), s.next(), s.next(), s.nextInt(),
                    s.nextDouble(), s.nextDouble(), s.nextDouble()));
        }
        int m = s.nextInt();
        for (int i = 0; i < m; i++) {
            list.add(new cmpstu(s.next(), s.next(), s.next(), s.nextInt(),
                    s.nextDouble(), s.nextDouble(), s.nextDouble(), s.nextDouble()));
        }
        list.sort((o1, o2) -> {
            if (o1.age != o2.age) {
                return o1.age - o2.age;
            }
            return Integer.parseInt(o1.number) - Integer.parseInt(o2.number);
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}

abstract class student {
    String number;
    String name;
    String gender;
    int age;
    double midterm;
    double endterm;

    public student(String number, String name, String gender, int age, double midterm, double endterm) {
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.midterm = midterm;
        this.endterm = endterm;
    }
    abstract double getAverage();
}
class engstu extends student {
    double speech;

    public engstu(String number, String name, String gender, int age, double speech, double midterm, double endterm) {
        super(number, name, gender, age, midterm, endterm);
        this.speech = speech;
    }

    @Override
    public String toString() {
        return number + ',' + name + ',' + gender + ',' + age + ",English,"
                + speech + ',' + midterm + ',' + endterm + ',' + getAverage();
    }

    @Override
    double getAverage() {
        long l = Math.round((speech * 0.5 + midterm * 0.25 + endterm * 0.25) * 10);
        return l / 10.0;
    }
}
class cmpstu extends student {
    double practical;
    double writing;

    public cmpstu(String number, String name, String gender, int age, double practical, double writing, double midterm, double endterm) {
        super(number, name, gender, age, midterm, endterm);
        this.practical = practical;
        this.writing = writing;
    }
    @Override
    public String toString() {
        return number + ',' + name + ',' + gender + ',' + age + ",Computer,"
                + practical + ',' + writing + ',' + midterm + ',' + endterm + ',' + getAverage();
    }

    @Override
    double getAverage() {
        long l = Math.round(((practical * 0.4 + writing * 0.2 + midterm * 0.2 + endterm * 0.2) * 10));
        return l / 10.0;
    }
}
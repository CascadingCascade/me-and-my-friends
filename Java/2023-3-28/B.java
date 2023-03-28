import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<undergrad> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int type = s.nextInt();
            if (type == 2) {
                list.add(new grad(s.next(), s.next(), s.next(), s.nextInt(), s.nextDouble()));
            } else {
                list.add(new undergrad(s.next(), s.next(), s.next(), s.nextDouble()));
            }
        }
        ArrayList<undergrad> exc = new ArrayList<>(n);
        ArrayList<grad> excm = new ArrayList<>(n);
        for (undergrad stu:
                list) {
            if (undergrad.isExc(stu)) {
                if (stu instanceof grad) {
                    excm.add((grad) stu);
                } else {
                    exc.add(stu);
                }
            }
        }
        exc.sort((o1, o2) -> {
            if (o1.overall > o2.overall) {
                return -1;
            }
            if (o1.overall < o2.overall) {
                return 1;
            }
            return Integer.parseInt(o1.number.substring(1)) -
                    Integer.parseInt(o2.number.substring(1));
        });
        excm.sort((o1, o2) -> {
            if (o1.overall > o2.overall) {
                return -1;
            }
            if (o1.overall < o2.overall) {
                return 1;
            }
            return Integer.parseInt(o1.number.substring(1)) -
                    Integer.parseInt(o2.number.substring(1));
        });
        if (exc.size() > 0) {
            System.out.println("excellent undergraduate student:");
            for (undergrad undergrad : exc) {
                System.out.print(undergrad);
                System.out.printf("%.3f\n", undergrad.overall);
            }
        }
        if (excm.size() > 0) {
            System.out.println("excellent graduate student:");
            for (grad student : excm) {
                System.out.print(student);
                System.out.printf("%.3f\n",student.overall);
            }
        }
    }

}
class undergrad {
    String number;
    String name;
    String pass;
    double overall;

    public undergrad(String number, String name, String pass, double overall) {
        this.number = number;
        this.name = name;
        this.pass = pass;
        this.overall = overall;
    }
    public static boolean isExc(undergrad undergrad) {
        if (undergrad instanceof grad) {
            return (((grad) undergrad).publish > 0) && (undergrad.pass.equals("true")) && (undergrad.overall > 85);
        }
        return (undergrad.pass.equals("true")) && (undergrad.overall > 85);
    }

    @Override
    public String toString() {
        return number +
                "," + name +
                "," + pass +
                ",";
    }
}
class grad extends undergrad {
    int publish;

    public grad(String number, String name, String pass, int publish, double overall) {
        super(number, name, pass, overall);
        this.publish = publish;
    }
    public String toString() {
        return  number +
                "," + name +
                "," + pass + ',' + publish +
                ",";
    }

}
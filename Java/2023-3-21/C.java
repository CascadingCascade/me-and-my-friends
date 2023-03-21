import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<Student> list1 = new ArrayList<>();
        ArrayList<Student> list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Student stu = new Student(s.next(), s.next(), s.nextInt());
            for (int j = 0; j < 4; j++) {
                stu.score.add(s.nextInt());
            }
            if (stu.type == 1) {
                list1.add(stu);
            } else {
                list2.add(stu);
            }
        }
        n = s.nextInt();
        ArrayList<Student> list3 = new ArrayList<>();
        ArrayList<Student> list4 = new ArrayList<>();
        ArrayList<Student> list5 = new ArrayList<>();
        ArrayList<Student> list6 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Student stu = new Student(s.next(), s.next(), s.nextInt() + s.nextInt() * 10);
            for (int j = 0; j < 5; j++) {
                stu.score.add(s.nextInt());
            }
            switch (stu.type) {
                case 11 -> {
                    list3.add(stu);
                }
                case 12 -> {
                    list4.add(stu);
                }
                case 21 -> {
                    list5.add(stu);
                }
                case 22 -> {
                    list6.add(stu);
                }
            }
        }
        list1.sort(new Cmp1());
        list2.sort(new Cmp1());
        list3.sort(new Cmp2());
        list4.sort(new Cmp2());
        list5.sort(new Cmp2());
        list6.sort(new Cmp2());
        for (Student stu:
                list1) {
            System.out.println(stu);
        }
        for (Student stu:
                list2) {
            System.out.println(stu);
        }
        for (Student stu:
                list3) {
            System.out.println(stu);
        }
        for (Student stu:
                list4) {
            System.out.println(stu);
        }
        for (Student stu:
                list5) {
            System.out.println(stu);
        }
        for (Student stu:
                list6) {
            System.out.println(stu);
        }
    }


}
class Student {
    String id;
    String name;
    int type;
    ArrayList<Integer> score = new ArrayList<>();

    public Student(String id, String name, int type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
    public int getTotal() {
        try {
            int n = score.get(4);
            return score.get(0) + score.get(1) + score.get(2) + score.get(3) + n;
        } catch (IndexOutOfBoundsException e) {
            return score.get(0) + score.get(1) + score.get(2) + score.get(3);
        }

    }

    @Override
    public String toString() {
        try {
            int n = score.get(4);
            return id + "," + name + "," + score.get(0) + "," + score.get(1) + "," + score.get(2) + "," + score.get(3) + "," + n + "," + getTotal() + "," + type;
        } catch (IndexOutOfBoundsException e) {
            return id + "," + name + "," + score.get(0) + "," + score.get(1) + "," + score.get(2) + "," + score.get(3) + "," + getTotal() + "," + type;
        }
    }
}
class Cmp1 implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getTotal() != o2.getTotal()) {
            return o2.getTotal() - o1.getTotal();
        }
        return Integer.parseInt(o1.id) - Integer.parseInt(o2.id);
    }
}
class Cmp2 implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getTotal() != o2.getTotal()) {
            return o2.getTotal() - o1.getTotal();
        }
        if (!Objects.equals(o1.score.get(4), o2.score.get(4))) {
            return o2.score.get(4) - o1.score.get(4);
        }
        return Integer.parseInt(o1.id) - Integer.parseInt(o2.id);
    }
}
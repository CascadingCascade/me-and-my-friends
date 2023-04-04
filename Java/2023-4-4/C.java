import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        if (type == 1) {
            scanner.nextLine();
            String c = scanner.nextLine();
            int n = scanner.nextInt();
            System.out.println(c);
            System.out.println(new MyString(c).multiply(n));
            return;
        }
        if (type == 2) {
            int n = scanner.nextInt();
            ArrayList<Integer> list = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                list.add(scanner.nextInt());
            }

            int n2 = scanner.nextInt();

            MyArray array = new MyArray(list);
            array.out();

            ArrayList<Integer> list2 = array.multiply(n2);
            MyArray array1 = new MyArray(list2);
            array1.out();
        }
    }

}
interface Mul<T>{
    T multiply(int n);
}
class MyString implements Mul<String> {
    String content;

    public MyString(String content) {
        this.content = content;
    }

    @Override
    public String multiply(int n) {
        return String.valueOf(content).repeat(Math.max(0, n));
    }
}
class MyArray implements Mul<ArrayList<Integer>> {
    ArrayList<Integer> content;

    public MyArray(ArrayList<Integer> content) {
        this.content = content;
    }

    @Override
    public ArrayList<Integer> multiply(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.addAll(content);
        }
        return list;
    }
    public void out(){
        int n = content.size();
        System.out.print(n + " ");
        for (int i = 0; i < n; i++) {
            System.out.print(content.get(i));
            if (i != n - 1) System.out.print(",");
        }
        System.out.println();
    }
}

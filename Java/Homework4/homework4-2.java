import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(s.nextInt());
        }
        int count = 0;
        ArrayList<Integer> found = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int o = list.get(i) + list.get(j);
                if (list.contains(o) && !found.contains(o)) {
                    count++;
                    found.add(o);
                }
            }
        }
        System.out.println(count);
        }
    }

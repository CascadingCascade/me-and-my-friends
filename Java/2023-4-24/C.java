import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in;
        ArrayList<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            in = scanner.nextLine().toLowerCase();
            String[] str = in.split("[^([\u4e00-\u9fa5]|\\w)]");
            for (String s:
                 str) {
                if (!list.contains(s)) {
                    list.add(s);
                }
            }
        }
        if (list.contains("i")) {
            list.remove("i");
            list.add("I");
        }
        list.remove("");
        list.sort(Comparator.naturalOrder());
        System.out.printf("sum:%d\n", list.size());
        if (list.size() > 0) {
            for (int i = 1; i < list.size() + 1; i++) {
                System.out.printf("%d:%s\n",i , list.get(i - 1));
            }
        }
    }
}
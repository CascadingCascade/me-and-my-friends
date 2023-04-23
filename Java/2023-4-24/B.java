import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in;
        long sum = 0;
        while (scanner.hasNextLine()) {
            in = scanner.nextLine();
            String[] str = in.split("\\D");
            for (String s : str) {
                if (s.length() > 0) {
                    try {
                        sum += Long.parseLong(s);
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        }
        System.out.println(sum);
    }
}

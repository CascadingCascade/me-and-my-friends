import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] ds = s.split("-");
        if (ds.length != 3 || ds[0].length() != 4 ||
                !(ds[0].startsWith("19") || ds[0].startsWith("20"))) {
            System.out.println(false);
            System.exit(0);
        }
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        try {
            format.parse(s);
        } catch (ParseException e) {
            System.out.println(false);
            System.exit(0);
        }
        System.out.println(true);
    }

}
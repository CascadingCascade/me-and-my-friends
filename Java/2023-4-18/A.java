import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal decimal1 = new BigDecimal(scanner.nextLine());
        BigDecimal decimal2 = new BigDecimal(scanner.nextLine());
        System.out.println(decimal1.add(decimal2));
        System.out.println(decimal1.multiply(decimal2));
    }

}
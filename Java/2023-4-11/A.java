import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String in = "";
        try {
            in = reader.readLine();
        } catch (Exception ignored) {
        }
        String num[] = in.split("/");
        int a = 0,b = 0;
        try {
            a = Integer.parseInt(num[0]);
            b = Integer.parseInt(num[1]);
        } catch (Exception e) {
            System.out.println("Error:the two numbers must be integer");
            System.exit(0);
        }
        if (b == 0) {
            System.out.println("Error:the second number must be not 0");
            System.exit(0);
        }
        System.out.printf("%.1f",(double)a / (double)b);
    }

}
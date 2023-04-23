import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in;
        HashMap<Character, Integer> dict = new HashMap<>();
        while (scanner.hasNextLine()) {
            in = scanner.nextLine();
            for (int i = 0; i < in.length(); i++) {
                char key = Character.toLowerCase(in.charAt(i));
                if (dict.get(key) != null) {
                    int count = dict.get(key);
                    count++;
                    dict.put(key,count);
                } else {
                    dict.put(key, 1);
                }
            }
        }
        char[] keys = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (char key : keys) {
            if (dict.get(key) != null) {
                System.out.printf("%c:%d\n", key, dict.get(key));
            }
        }
    }
}


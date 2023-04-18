import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Participant> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            Participant p = new Participant();
            String in = scanner.nextLine();
            if (in.startsWith("end")) break;
            String[] t = in.split(" ");
            if (t.length != 2) continue;
            p.name = t[0];
            p.phoneNumber = t[1];
            if (p.validate()) {
                p.encrypt();
                list.add(p);
            }
        }
        if (list.size() > 0) {
            System.out.println("winner list:");
            list.sort(Comparator.comparing(o -> o.phoneNumber));
            for (int i = 0; i < list.size(); i += 2) {
                Participant p = list.get(i);
                System.out.printf("%s %s\n", p.eName, p.eNumber);
            }
        }

    }
}
class Participant {
    String name;
    String phoneNumber;
    String eName;
    String eNumber;

    Participant(){}

    public Participant(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    boolean validate() {
        if (name.length() <= 1) return false;
        if (phoneNumber.length() != 11) return false;
        Pattern pattern = Pattern.compile("1[3-9]\\d\\d\\d\\d\\d\\d\\d\\d\\d");
        return pattern.matcher(phoneNumber).matches();
    }
    void encrypt() {
        StringBuilder builder = new StringBuilder();
        builder.append(name.charAt(0));
        if (name.length() <= 2) {
            builder.append('*');
        } else {
            builder.append("*".repeat(name.length() - 2));
            builder.append(name.charAt(name.length() - 1));
        }
        eName = builder.toString();
        builder = new StringBuilder();
        builder.append(phoneNumber,0 , 3);
        builder.append("*****");
        builder.append(phoneNumber,8 , 11);
        eNumber = builder.toString();
    }
}

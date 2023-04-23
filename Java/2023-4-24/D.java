import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in;
        int index = 1;
        boolean f = false;
        ArrayList<String> formats = new ArrayList<>();
        ParseFormat format = new ParseFormat();
        while (scanner.hasNextLine()) {
            if (!f) {
                in = scanner.nextLine();
                if (in.contains("--this is the separator--")) {
                    f = true;
                    format.format = formats;
                    continue;
                }
                formats.addAll(Arrays.stream(in.split(" ")).toList());
                continue;
            }
            in = scanner.nextLine();
            FRecord fRecord = null;
            try {
                fRecord = format.Parse(in);
            } catch (InputMismatchException e) {
                System.out.printf("#record %d:format error\n", index);
                System.exit(0);
            }
            fRecord.Out(index);
            index++;
        }

    }
}

class FRecord {
    int intsum = 0;
    double doublesum = 0.0;
    String shortest;

    void Out(int index) {
        System.out.printf("#record %d:\nsumint:%d\nsumdouble:%.2f\nshortString:%s\n", index, intsum, doublesum, shortest);
    }
}

class ParseFormat {
    ArrayList<String> format;

    FRecord Parse(String line) throws InputMismatchException {
        Scanner scanner = new Scanner(line);
        String sts = null;
        FRecord rec = new FRecord();
        for (int i = 0; i < format.size(); i++) {
            String f = format.get(i);
            if (f.equals("int")) {
                try {
                    rec.intsum += scanner.nextInt();
                } catch (NumberFormatException e) {
                    throw new InputMismatchException();
                }
            }
            if (f.equals("double")) {
                try {
                    rec.doublesum += scanner.nextDouble();
                } catch (NumberFormatException e) {
                    throw new InputMismatchException();
                }
            }
            if (f.equals("String")) {
                StringBuilder s = new StringBuilder(scanner.next());
                String lookahead = "";
                if (i != format.size() - 1)
                    lookahead = format.get(i + 1);
                while (scanner.hasNext()) {
                    if (lookahead.equals("int") && scanner.hasNextInt() ||
                        lookahead.equals("double") && scanner.hasNextDouble()) {
                        break;
                    }
                    s.append(" ").append(scanner.next());
                }
                String sts1 = String.valueOf(s);
                if (sts == null) {
                    sts = sts1;
                }
                else sts = (sts1.length() < sts.length()) ? sts1 : sts;
            }
        }
        if (scanner.hasNext()) {
            throw new InputMismatchException();
        }
        rec.shortest = sts;
        return rec;
    }
}
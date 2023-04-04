import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Grad> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(new Grad(scanner.next(), scanner.next(),
                    scanner.next(), scanner.nextInt(), scanner.nextInt()));
        }
//        list.sort(Comparator.comparingInt(o -> Integer.parseInt(o.number.substring(1))));
        for (Grad g:
                list) {
            if ((g.pay * 12 - g.fee * 2) < 2000) {
                System.out.printf("%s,%s,%s\n", g.number,g.name,g.needLoan());
            }
        }
    }

}
interface StuInt {
    void setFee(int fee);
    int getFee();
}
interface TeaInt {
    void setPay(int Pay);
    int getPay();
}
class Grad implements StuInt, TeaInt {
    public Grad(String number, String name, String gender, int fee, int pay) {
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.fee = fee;
        this.pay = pay;
    }

    String number;
    String name;
    String gender;
    int fee;
    int pay;

    @Override
    public int getFee() {
        return fee;
    }

    @Override
    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public int getPay() {
        return pay;
    }

    @Override
    public void setPay(int pay) {
        this.pay = pay;
    }
    String needLoan() {
        if ((pay * 12 - fee * 2) < 2000) {
            return "provide a loan";
        }
        return "";
    }
}
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int cy, cm, cd;
        Scanner s = new Scanner(System.in);
        cy = s.nextInt();
        cm = s.nextInt();
        cd = s.nextInt();
        int n = s.nextInt();
        IdentityCard card;
        for (int i = 0; i < n; i++) {
            card = new IdentityCard(s.next());
            if(card.check())
                System.out.println("true:"+card.getAge(cy,cm,cd));
            else
                System.out.println("false:-1");
        }
    }
}

class IdentityCard{
    public IdentityCard(String ID) {
        this.ID = ID;
    }

    private String ID;
    private int year;
    private int month;
    private int day;
    public boolean check() {
        if(!ID.matches("[1-9][0-9]{5}(19|20)[0-9]{9}[0-9Xx]")) {
            return false;
        }
        year = Integer.parseInt(ID.substring(6, 10));
        month = Integer.parseInt(ID.substring(10, 12));
        day = Integer.parseInt(ID.substring(12, 14));
        if(!dateLegal()) {
            return false;
        }
        int sum = 0;
        char ch[]=ID.toCharArray();
        int[] weight = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
        for (int i = 0; i < ID.length() - 1; i++) {
            sum += weight[i] * Integer.parseInt(String.valueOf(ch[i]));
        }
        int yu = sum % 11;
        if (yu == 2) {
            return Character.toLowerCase(ch[17]) == 'x';
        }
        int[] code = {1,0,0,9,8,7,6,5,4,3,2};
        return code[yu] == Integer.parseInt(String.valueOf(ch[17]));
    }
    boolean dateLegal(){
        String Format = "yyyy-MM-dd";
        String sample = year + "-" + month + "-" + day;
        try {
            DateFormat df = new SimpleDateFormat(Format);
            df.setLenient(false);
            df.parse(sample);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    public int getAge(int y,int m,int d) {
        if (!check()) return -1;
        int age = y - year - 1;
        if (month < m) {
            age++;
        } else if (month == m && day < d) {
            age++;
        }
        return age;
    }
}

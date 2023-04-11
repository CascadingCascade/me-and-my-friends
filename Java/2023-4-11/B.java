import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String in = "";
        try {
            in = reader.readLine();
        } catch (Exception ignored) {
        }
        ArrayList<MyPoint> list = new ArrayList<>();
        String[] n = in.split(" ");
        for (String s : n) {
            int x, y;
            String[] n2 = s.split(",");
            x = Integer.parseInt(n2[0].substring(1));
            y = Integer.parseInt(n2[1].substring(0, n2[1].length() - 1));
            list.add(new MyPoint(x, y));
        }
        try {
            in = reader.readLine();
        } catch (Exception ignored) {
        }
        String[] num = in.split(" ");
        MyPoint p1,p2,p3;
        p1 = list.get(Integer.parseInt(num[0]));
        p2 = list.get(Integer.parseInt(num[1]));
        p3 = list.get(Integer.parseInt(num[2]));
        boolean res = false;
        try {
            res = p1.isLine(p2,p3);
        } catch (MyPointException e) {
            System.out.println(e);
            System.exit(0);
        }
        System.out.println(res);
    }

}
class MyPointException extends Exception {
    @Override
    public String toString() {
        return "the same point, it is illegal";
    }
}
class MyPoint {
    private int x;
    private int y;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MyPoint) {
            return x == ((MyPoint) obj).getX() && y == ((MyPoint) obj).getY();
        }
        return false;
    }

    boolean isLine(MyPoint p1, MyPoint p2) throws MyPointException {
        if (p1.equals(p2) || this.equals(p1) || this.equals(p2)) {
            throw new MyPointException();
        }
        return (getX() - p2.getX()) * (p1.getY() - p2.getY()) -
                (p1.getX() - p2.getX()) * (getY() - p2.getY()) == 0;
    }
}

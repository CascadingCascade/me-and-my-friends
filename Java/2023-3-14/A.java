import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        Fan fan;
        for (int i = 0; i < n; i++) {
            fan = new Fan();
            fan.setStatus(s.next());
            fan.setSpeed(s.nextInt());
            fan.setRadius(s.nextInt());
            fan.setColor(s.next());
            System.out.println(fan);
        }
    }
}
class Fan {
    private boolean status = false;
    private int speed = 0;
    private int radius = 5;
    private String color = "black";

    public String getStatus() {
        if (status) return "ON";
        return "OFF";
    }

    public void setStatus(String status) {
        this.status = status.equals("ON");
    }

    public String getSpeed() {
        if (speed == 0) return "quiet";
        if (speed < 4) return "slow";
        if (speed < 8) return "middle";
        return "quick";
    }

    public void setSpeed(int speed) {
        if (!status) return;
        if (speed > 9) {
            this.speed = 9;
            return;
        }
        if (speed < 0) {
            this.speed = 0;
            return;
        }
        this.speed = speed;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius < 5) {
            this.radius = 5;
            return;
        }
        if (radius > 10) {
            this.radius = 10;
            return;
        }
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color.equals("gray")) {
            this.color = "gray";
            return;
        }
        if (color.equals("white")) {
            this.color = "white";
            return;
        }
        this.color = "black";
    }

    @Override
    public String toString() {
        return
                "Status:" + getStatus() +
                ";Speed:" + getSpeed() +
                ";FanRadius:" + radius +
                ";FanColor:" + color
                ;
    }
}

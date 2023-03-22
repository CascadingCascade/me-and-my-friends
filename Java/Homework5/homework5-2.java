import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int type = s.nextInt();
        if (type == 1) {
            Pig pig = new Pig(s.next(), s.nextInt(), s.next(), s.nextInt(),
                    s.nextDouble(), s.nextDouble(), s.nextDouble(), s.next());
            String f = s.next();
            System.out.println(pig);
            pig.eating(f);
            pig.walking();
            return;
        }
        Chicken chicken = new Chicken(s.next(), s.nextInt(), s.next(),
                s.nextInt(), s.nextDouble(), s.next());
        String f = s.next();
        System.out.println(chicken);
        chicken.eating(f);
        chicken.flying();
    }

}
class Animal {
    protected String name;
    protected int age;
    protected String sex;
    protected int legNum;
    protected double weight;

    Animal(){}

    public Animal(String name, int age, String sex, int legNum, double weight) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.legNum = legNum;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + "," + age + "," + sex +"," + legNum + "," + weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getLegNum() {
        return legNum;
    }

    public void setLegNum(int legNum) {
        this.legNum = legNum;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    protected void eating(String food) {
        System.out.printf("%s is eating %s.\n", name, food);
    }
}

class Pig extends Animal {
    protected double length;
    protected double height;
    protected String color;
    private static ArrayList<String> allowedFood = new ArrayList<>();

    static {
        allowedFood.add("pigwash");
        allowedFood.add("cabbage");
        allowedFood.add("pigweed");
    }

    public Pig(String name, int age, String sex, int legNum,
               double weight, double length, double height, String color) {
        super(name, age, sex, legNum, weight);
        this.length = length;
        this.height = height;
        this.color = color;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return name + ',' + age + ',' + sex + ',' + legNum
                + ',' + weight + ',' + length + ',' + height + ',' + color;
    }

    public void walking() {
        System.out.printf("%s is walking.\n", name);
    }

    @Override
    protected void eating(String food) {
        if (allowedFood.contains(food)){
            super.eating(food);
        }
    }
}

class Chicken extends Animal {
    protected String combColor;

    public Chicken(String name, int age, String sex, int legNum, double weight, String combColor) {
        super(name, age, sex, legNum, weight);
        this.combColor = combColor;
    }

    public String getCombColor() {
        return combColor;
    }

    public void setCombColor(String combColor) {
        this.combColor = combColor;
    }

    @Override
    public String toString() {
        return name + "," + age + "," + sex +"," + legNum + "," + weight + ',' + combColor;
    }

    public void flying() {
        System.out.printf("%s is flying.\n", name);
    }
}
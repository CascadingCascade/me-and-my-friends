public class Main {

    public static void main(String[] args) {
        Vehicle v1 = new Car();
        Vehicle v2 = new Motorbike();
        System.out.println(v1.NoOfWheels());
        System.out.println(v2.NoOfWheels());
    }

}

abstract class Vehicle {
    abstract String NoOfWheels();
}
class Car extends Vehicle {
    @Override
    String NoOfWheels() {
        return "Four";
    }
}
class Motorbike extends Vehicle {
    @Override
    String NoOfWheels() {
        return "Two";
    }
}
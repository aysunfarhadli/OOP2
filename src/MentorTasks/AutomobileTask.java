package MentorTasks;

public class AutomobileTask {

    interface Movable {
        void move();
    }

    interface Fuelable {
        void fuel();
    }

    static class Vehicle { }

    static class Car extends Vehicle
            implements Movable, Fuelable {

        @Override
        public void move() {
            System.out.println("Car is moving.");
        }

        @Override
        public void fuel() {
            System.out.println("Car is refueling.");
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.move();
        car.fuel();
    }
}
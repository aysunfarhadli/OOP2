package MentorTasks;

public class HomeTaskDynamicEntities {

    // ===== Interface =====
    interface Describable {
        void describe();
    }

    interface Actable {
        void performAction();
    }

    // ===== Abstract Class =====
    abstract static class Entity implements Describable {
        protected String name;

        public Entity(String name) {
            this.name = name;
        }

        public abstract void interact();
    }

    // ===== Person Class =====
    static class Person extends Entity implements Actable {
        private int age;

        public Person(String name, int age) {
            super(name);
            this.age = age;
        }

        @Override
        public void describe() {
            System.out.println(name + " (" + age + ")");
        }

        @Override
        public void interact() {
            System.out.println(name + " salamlaşır.");
        }

        @Override
        public void performAction() {
            System.out.println(name + " öyrənir.");
        }
    }

    // ===== Vehicle Class =====
    static class Vehicle extends Entity implements Actable {
        private String type;

        public Vehicle(String name, String type) {
            super(name);
            this.type = type;
        }

        @Override
        public void describe() {
            System.out.println(type + ": " + name);
        }

        @Override
        public void interact() {
            System.out.println(name + " işə salındı.");
        }

        @Override
        public void performAction() {
            System.out.println(name + " hərəkət edir.");
        }
    }

    // ===== Device Class =====
    static class Device extends Entity implements Actable {
        private boolean isOn = false;

        public Device(String name) {
            super(name);
        }

        @Override
        public void describe() {
            System.out.println("Cihaz: " + name);
        }

        @Override
        public void interact() {
            isOn = !isOn;
            if (isOn) {
                System.out.println(name + " açıldı.");
            } else {
                System.out.println(name + " bağlandı.");
            }
        }

        @Override
        public void performAction() {
            System.out.println(name + " funksiyasını yerinə yetirir.");
        }
    }

    // ===== MAIN =====
    public static void main(String[] args) {

        System.out.println("Dynamic Entities Sistemi başladılır...\n");

        Person person = new Person("Ali", 30);
        person.describe();
        person.interact();
        person.performAction();

        System.out.println("---");

        Vehicle vehicle = new Vehicle("Tesla", "Car");
        vehicle.describe();
        vehicle.interact();
        vehicle.performAction();

        System.out.println("---");

        Device device = new Device("Smartfon");
        device.describe();
        device.interact();
        device.performAction();
        device.interact();

        System.out.println("\nDynamic Entities Sistemi tamamlandı.");
    }
}
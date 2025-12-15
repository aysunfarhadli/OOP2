package MentorTasks;

public class DeviceTask {

    interface Connectable {
        void connectToWiFi();
    }

    interface Chargeable {
        void charge();
    }

    static class Device { }

    static class Smartphone extends Device
            implements Connectable, Chargeable {

        @Override
        public void connectToWiFi() {
            System.out.println("Smartphone connected to WiFi.");
        }

        @Override
        public void charge() {
            System.out.println("Smartphone charging.");
        }
    }

    static class Laptop extends Device
            implements Connectable, Chargeable {

        @Override
        public void connectToWiFi() {
            System.out.println("Laptop connected to WiFi.");
        }

        @Override
        public void charge() {
            System.out.println("Laptop charging.");
        }
    }

    public static void main(String[] args) {
        Smartphone phone = new Smartphone();
        Laptop laptop = new Laptop();

        phone.connectToWiFi();
        phone.charge();

        laptop.connectToWiFi();
        laptop.charge();
    }
}
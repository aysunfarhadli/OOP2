package MentorTasks;

public class Inheritance {

    // ==============================
    // Lesson 8- Parent Class: SmartDevice
    // ==============================
    // Bu sinif butunn smart cihazlar uchun  ortag olan saheleri ve davranishlari ozunde saxlayir.
    static class SmartDevice {

        // protected: alt sinifler bu field-lara birbasha cata bilsin deye
        protected String brand;
        protected String model;
        protected boolean isOnline; // Cihazin internete qoshulu olub-olmamasi

        // Constructor – butun smart cihazlar uchun marka vee model teyin edirik
        public SmartDevice(String brand, String model) {
            this.brand = brand;
            this.model = model;
            this.isOnline = false; // ilk bsda baslangic olarag offline kimi goturek.
        }

        // WiFi-a qoshulma metodu – alt sinifler bunu override edecek
        public void connectToWiFi() {
            isOnline = true;
            System.out.println(brand + " " + model + " internetə qoşuldu. (Parent default)");
        }

        // WiFi-dan ayrılma metodu -eyni sekilde override edib genislendirri
        public void disconnect() {
            isOnline = false;
            System.out.println(brand + " " + model + " internet bağlantısını kəsdi. (Parent default)");
        }
    }

    // ==============================
    // 2) Child Class: SmartWatch
    // ==============================
    static class SmartWatch extends SmartDevice {

        // gelecekde batteryLevel kimi elave saheler de elave etmek olar (Bonus)
        protected int batteryLevel;

        // Constructor – burda super() funcla parent constructor-a brand/model oturur.
        public SmartWatch(String brand, String model, int batteryLevel) {
            super(brand, model); // Parent (SmartDevice) constructor-un çağırılması
            this.batteryLevel = batteryLevel;
        }

        // SmartWatch -un ozune aid funksiya davranisi
        public void trackHeartRate() {
            if (isOnline) {
                System.out.println("⌚ " + brand + " " + model +
                        " ürək döyüntüsünü izləyir. Battery: " + batteryLevel + "%");
            } else {
                System.out.println("⌚ " + brand + " " + model +
                        " ürək döyüntüsünü izləmək üçün internet bağlantısı tələb edir.");
            }
        }

        // Parent metodunu override edirik – saat ucun daha konkret mesaj
        @Override
        public void connectToWiFi() {
            isOnline = true;
            System.out.println(brand + " " + model + " internetə qoşuldu.");
            System.out.println("⌚ Saat artıq məlumat toplayır.");
        }

        @Override
        public void disconnect() {
            isOnline = false;
            System.out.println("⌚ " + brand + " " + model + " internetdən ayrıldı.");
        }
    }

    // ==============================
    // 3) Child Class: SmartSpeaker
    // ==============================
    static class SmartSpeaker extends SmartDevice {

        public SmartSpeaker(String brand, String model) {
            super(brand, model);
        }

        public void playMusic() {
            if (isOnline) {
                System.out.println("🔊 " + brand + " " + model +
                        " musiqi yayımlamağa hazırdır.");
            } else {
                System.out.println("🔊 " + brand + " " + model +
                        " musiqi çalmaq üçün internetə qoşulmayıb.");
            }
        }

        @Override
        public void connectToWiFi() {
            isOnline = true;
            System.out.println(brand + " " + model + " internetə qoşuldu.");
            System.out.println("🔊 Səsgücləndirici musiqi yayımlamağa hazırdır.");
        }

        @Override
        public void disconnect() {
            isOnline = false;
            System.out.println("🔊 " + brand + " " + model + " WiFi bağlantısını kəsdi.");
        }

        // Bonus -volumUp() volume hecm funksionaligi artirmg ucun method elave etmishem
        public void volumeUp() {
            System.out.println("🔊 " + brand + " " + model + ": Səs bir pillə artırıldı.");
        }
    }

    // ==============================
    // 4) Child Class: SmartFridge
    // ==============================
    static class SmartFridge extends SmartDevice {

        private int coolingLevel; // soyutma derecesi (mes. 1-5 arasi)

        public SmartFridge(String brand, String model, int coolingLevel) {
            super(brand, model);
            this.coolingLevel = coolingLevel;
        }

        public void showTemperature() {
            // MIni noe for-ters utenasiblik var cooling level artigca temp azalir.
            int approximateTemp = 10 - coolingLevel; // sırf nümunə üçün
            if (isOnline) {
                System.out.println("🧊 " + brand + " " + model +
                        " təxmini daxili temperatur: " + approximateTemp + "°C");
            } else {
                System.out.println("🧊 " + brand + " " + model +
                        " offline-dir, amma soyutma səviyyəsi: " + coolingLevel);
            }
        }

        @Override
        public void connectToWiFi() {
            isOnline = true;
            System.out.println(brand + " " + model + " internetə qoşuldu.");
            System.out.println("🧊 Soyuducu məhsulların siyahısını sinxronlaşdırır.");
        }

        @Override
        public void disconnect() {
            isOnline = false;
            System.out.println("🧊 " + brand + " " + model + " offline moda keçdi.");
        }
    }

    //Main-------////
    public static void main(String[] args) {

        // Polymorphism: butun cihazlar smartdevice tipinden ist edib saxlayirig.
        SmartDevice watch = new SmartWatch("Apple", "Watch Series 9", 85);
        SmartDevice speaker = new SmartSpeaker("Amazon", "Echo Dot");
        SmartDevice fridge = new SmartFridge("Samsung", "SmartCool 3000", 4);

        // WiFi-a qosulurug
        watch.connectToWiFi();
        speaker.connectToWiFi();
        fridge.connectToWiFi();

        System.out.println();


        ((SmartWatch) watch).trackHeartRate();
        ((SmartSpeaker) speaker).playMusic();
        ((SmartFridge) fridge).showTemperature();

        System.out.println();

        // WiFi-dan ayirma
        watch.disconnect();
        speaker.disconnect();
        fridge.disconnect();
    }
}

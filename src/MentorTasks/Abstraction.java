package MentorTasks;

public class Abstraction {

    // ===========================
    // ABSTRACT PARENT CLASS
    // ===========================
    abstract static class Product {

        protected String name;
        protected double price;

        // Constructor
        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        // Abstract metod – subclasslar ucun mutelg override edilmelidir(menc)
        public abstract void displayInfo();

        // Normal metod//
        public void applyDiscount(double percent) {
            price = price - (price * percent / 100);
        }
    }

    // ===========================
    // BOOK CLASS
    // ===========================
    static class Book extends Product {

        private String author;

        public Book(String name, double price, String author) {
            super(name, price);    // abstract class constructor-un cagirilimasi
            this.author = author;
        }

        @Override
        public void displayInfo() {
            System.out.println("📘 Kitab: " + name +
                    " | Müəllif: " + author +
                    " | Qiymət: " + price + " AZN");
        }
    }

    // ===========================
    // ELECTRONIC CLASS
    // ===========================
    static class Electronic extends Product {

        private String brand;

        public Electronic(String name, double price, String brand) {
            super(name, price);
            this.brand = brand;
        }

        @Override
        public void displayInfo() {
            System.out.println("💻 Elektron məhsul: " + name +
                    " | Brend: " + brand +
                    " | Qiymət: " + price + " AZN");
        }
    }

    // ===========================
    // MAIN —-----/////
    // ===========================
    public static void main(String[] args) {

        Product book = new Book("Java 101", 50.0, "James Gosling");
        Product laptop = new Electronic("Ultra Laptop", 2500.0, "Lenovo");

        System.out.println("---- Əvvəl ----");
        book.displayInfo();
        laptop.displayInfo();

        // 20% endirim
        book.applyDiscount(20);
        laptop.applyDiscount(20);

        System.out.println("\n---- Endirimdən sonra ----");
        book.displayInfo();
        laptop.displayInfo();
    }
}

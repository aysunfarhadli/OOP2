package MentorTasks;

public class OnlineStoreTask {

    // ===== Interface =====
    interface DiscountApplicable {
        double calculateDiscountedPrice(double rate);
    }

    // ===== Base Class =====
    static class Product {
        private String name;
        private double price;
        private int stock;

        public Product(String name, double price, int stock) {
            this.name = name;
            this.price = price;
            this.stock = stock;
        }

        public String getName() { return name; }
        public double getPrice() { return price; }
        public int getStock() { return stock; }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public void showInfo() {
            System.out.println(
                    "Product: " + name +
                            ", Price: " + price +
                            ", Stock: " + stock
            );
        }
    }

    // ===== Child Class =====
    static class ElectronicProduct extends Product
            implements DiscountApplicable {

        private String warranty;

        public ElectronicProduct(String name, double price,
                                 int stock, String warranty) {
            super(name, price, stock);
            this.warranty = warranty;
        }

        @Override
        public void showInfo() {
            System.out.println(
                    "Electronic: " + getName() +
                            ", Price: " + getPrice() +
                            ", Stock: " + getStock() +
                            ", Warranty: " + warranty
            );
        }

        @Override
        public double calculateDiscountedPrice(double rate) {
            return getPrice() * (1 - rate);
        }
    }

    // ===== Child Class =====
    static class ApparelProduct extends Product
            implements DiscountApplicable {

        private String size;

        public ApparelProduct(String name, double price,
                              int stock, String size) {
            super(name, price, stock);
            this.size = size;
        }

        @Override
        public void showInfo() {
            System.out.println(
                    "Apparel: " + getName() +
                            ", Price: " + getPrice() +
                            ", Stock: " + getStock() +
                            ", Size: " + size
            );
        }

        @Override
        public double calculateDiscountedPrice(double rate) {
            return getPrice() * (1 - rate);
        }
    }

    // ===== Order Class =====
    static class Order {
        void createOrder(Product p, int qty) {
            if (p.getStock() < qty) {
                System.out.println("Not enough stock for " + p.getName());
            } else {
                p.setStock(p.getStock() - qty);
                System.out.println("Order confirmed: " + qty + " " + p.getName());
            }
        }
    }

    // ===== MAIN =====
    public static void main(String[] args) {

        ElectronicProduct phone =
                new ElectronicProduct("Phone", 1200, 10, "2 years");
        ApparelProduct shirt =
                new ApparelProduct("T-shirt", 35, 20, "M");

        phone.showInfo();
        shirt.showInfo();

        Order order = new Order();
        order.createOrder(phone, 2);

        System.out.println(
                "Discounted price: " +
                        phone.calculateDiscountedPrice(0.15)
        );
    }
}
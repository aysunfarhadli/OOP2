package MainTasks;


public class CurrencyMain {
    public static void main(String[] args) {
        Currency usd = new USD();
        double azn = MainTasks.CurrencyConverter.CurrencyConverter.convertToAZN(usd, 100);
        System.out.println("100 USD -> " + azn + " AZN");
    }
}


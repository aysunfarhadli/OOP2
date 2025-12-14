package MainTasks;

import MainTasks.Currency;

public class CurrencyConverter {

    public static CurrencyConverter CurrencyConverter;
    private static double commissionRate = 0.01;

    public static void setCommissionRate(double newRate) {
        if (newRate < 0 || newRate > 0.20) {
            throw new IllegalArgumentException("Komissiya 0% - 20% arasi olmalidir.");
        }
        commissionRate = newRate;
    }

    public static double convertToAZN(Currency currency, double amount) {
        double commission = amount * commissionRate;
        double netAmount = amount - commission;
        return netAmount * currency.rateToAZN();
    }
}

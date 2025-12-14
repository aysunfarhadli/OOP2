package MainTasks;

public class EUR implements Currency {

    @Override
    public double rateToAZN() {
        return 1.8; //--- 1EUR = 1.8 AZN---> konvertasiya merhelesi---//
    }

    @Override
    public String code() {
        return "EUR"; //---Konvertasiya edilen valyutain tipi/kodu---//
    }
}

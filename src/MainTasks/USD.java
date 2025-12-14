package MainTasks;

public class USD implements Currency {


    @Override
    public double rateToAZN() {
        return 1.7; //---USD - > AZN konvertasiya deyeri nedirse onu geyd edirik default deyer olarag ki onu geyd etsin ozu---//
    }

    @Override
    public String code() {
        return "USD";//---burda ise USD deyerini konvertasiya deyerine cevirir deye hemin deyeri cevirsin bu sekilde---//
    }
}

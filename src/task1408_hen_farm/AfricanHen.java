package task1408_hen_farm;

public class AfricanHen extends Hen implements Continent {

    public int getMonthlyEggCount() {
        return 3;
    }

    public String getDescription() {
        String description = super.getDescription() + " Pochodzę z " + AFRICA + ". Znoszę " + getMonthlyEggCount() + " jaj na miesiąc.";
        System.out.println(description);
        return description;
    }
}

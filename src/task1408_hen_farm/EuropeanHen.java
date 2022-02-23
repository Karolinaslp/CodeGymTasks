package task1408_hen_farm;

public class EuropeanHen extends Hen implements Continent {

    @Override
    public int getMonthlyEggCount() {
        return 6;
    }

    @Override
    public String getDescription() {
        String description = super.getDescription() + " Pochodzę z " + EUROPE + ". Znoszę " + getMonthlyEggCount() + " jaj na miesiąc.";
        System.out.println(description);
        return description;
    }
}

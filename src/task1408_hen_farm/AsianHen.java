package task1408_hen_farm;

public class AsianHen extends Hen implements Continent {

    @Override
    public int getMonthlyEggCount() {
        return 1;
    }

    @Override
    public String getDescription() {
        String description = super.getDescription() + " Pochodzę z " + ASIA + ". Znoszę " + getMonthlyEggCount() + " jaj na miesiąc.";
        System.out.println(description);
        return description;
    }
}

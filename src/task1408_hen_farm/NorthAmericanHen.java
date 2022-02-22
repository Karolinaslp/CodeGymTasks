package task1408_hen_farm;

public class NorthAmericanHen extends Hen implements Continent {

    public int getMonthlyEggCount() {
        return 5;
    }

    public String getDescription() {
        String description = super.getDescription() + " Pochodzę z " + NORTHAMERICA + ". Znoszę " + getMonthlyEggCount() + " jaj na miesiąc.";
        System.out.println(description);
        return description;
    }
}

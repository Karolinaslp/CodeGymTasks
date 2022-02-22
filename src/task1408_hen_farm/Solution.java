package task1408_hen_farm;

/* 
Ferma drobiu
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Continent.AFRICA);
        hen.getMonthlyEggCount();
        hen.getDescription();
    }

    static class HenFactory implements Continent {

        static Hen getHen(String continent) {
            return switch (continent) {
                case NORTHAMERICA -> new NorthAmericanHen();
                case EUROPE -> new EuropeanHen();
                case ASIA -> new AsianHen();
                case AFRICA -> new AfricanHen();
                default -> null;
            };
        }
    }
}

package strategy;

public class CommissionFactory {

    public static CommissionStrategy getCommissionStrategy(String brand, String categoryId) {
        if (brand.equals("APPLE") && categoryId.equals("MOBILE")) {
            return new PercentageCommissionStrategy();
        } else {
            return new FixedRateCommissionStrategy();
        }
    }
}

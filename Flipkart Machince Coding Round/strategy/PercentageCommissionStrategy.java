package strategy;

public class PercentageCommissionStrategy implements CommissionStrategy {
    @Override
    public double calculateCommission(double price) {
        if (price > 10000.00) {
            return price * (0.2);
        } else {
            return price * (0.1);
        }
    }
}

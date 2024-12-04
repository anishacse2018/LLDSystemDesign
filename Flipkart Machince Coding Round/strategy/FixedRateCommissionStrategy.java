package strategy;

public class FixedRateCommissionStrategy implements CommissionStrategy {
    @Override
    public double calculateCommission(double price) {
        return price / 10.0;
    }
}

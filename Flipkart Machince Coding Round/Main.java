import service.CommissionAppService;

public class Main {
    public static void main(String[] args) {
        CommissionAppService commissionAppService = CommissionAppService.getCommissionAppService();
        commissionAppService.execute();
    }
}
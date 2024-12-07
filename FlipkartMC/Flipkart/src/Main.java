import service.PropertyHuntService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to PropertyHunt!");
        PropertyHuntService propertyHuntService = PropertyHuntService.getPropertyHuntService();
        propertyHuntService.execute();
    }
}
package GeneralPractice.StrategyDesign;

public class Main {
    public static void main(String[] args) {

        Vehicle vehicle= new Bus();
        vehicle.drive();
        vehicle.display();
        vehicle= new Truck();
        vehicle.drive();
        vehicle.display();
        vehicle= new RaceCar();
        vehicle.drive();
        vehicle.display();
    }
}

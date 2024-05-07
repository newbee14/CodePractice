package GeneralPractice.StrategyDesign;

import GeneralPractice.StrategyDesign.Strategy.DisplayStrategy;
import GeneralPractice.StrategyDesign.Strategy.DriveStrategy;
import lombok.Data;

@Data
public class Vehicle{
    private DriveStrategy driveStrategy;
    private DisplayStrategy displayStrategy;
    public Vehicle(DriveStrategy driveStrategy, DisplayStrategy displayStrategy) {
        this.driveStrategy = driveStrategy;
        this.displayStrategy = displayStrategy;
    }

    public void drive() {
        System.out.println("Vehicle");
        this.driveStrategy.drive();
    }

    public void display() {
        System.out.println("Vehicle");
        this.displayStrategy.display();
    }
}

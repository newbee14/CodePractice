package GeneralPractice.StrategyDesign;

import GeneralPractice.StrategyDesign.Strategy.impl.BoxDisplayImpl;
import GeneralPractice.StrategyDesign.Strategy.impl.NormalDriveImpl;

public class Truck extends Vehicle{
    public Truck() {
        super(new NormalDriveImpl(), new BoxDisplayImpl());
    }

    public void drive() {
        System.out.println("Truck");
        this.getDriveStrategy().drive();
    }
}

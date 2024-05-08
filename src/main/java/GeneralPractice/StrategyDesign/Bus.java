package GeneralPractice.StrategyDesign;

import GeneralPractice.StrategyDesign.Strategy.impl.BoxDisplayImpl;
import GeneralPractice.StrategyDesign.Strategy.impl.NormalDriveImpl;

public class Bus extends Vehicle{
    public Bus() {
        super(new NormalDriveImpl(), new BoxDisplayImpl());
    }

    public void drive() {
        System.out.println("Bus");
        this.getDriveStrategy().drive();
    }
}

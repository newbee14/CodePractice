package GeneralPractice.StrategyDesign;


import GeneralPractice.StrategyDesign.Strategy.impl.LuxuryDisplayImpl;
import GeneralPractice.StrategyDesign.Strategy.impl.RaceCarDriveImpl;

public class RaceCar extends Vehicle {
    public RaceCar() {
        super(new RaceCarDriveImpl(), new LuxuryDisplayImpl());
    }
}

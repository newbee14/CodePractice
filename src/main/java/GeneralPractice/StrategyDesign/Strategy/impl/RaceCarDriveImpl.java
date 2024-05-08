package GeneralPractice.StrategyDesign.Strategy.impl;

import GeneralPractice.StrategyDesign.Strategy.DriveStrategy;

public class RaceCarDriveImpl implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("RaceCar Drive");
    }

    @Override
    public int getSpeed() {
        return 200;
    }
}

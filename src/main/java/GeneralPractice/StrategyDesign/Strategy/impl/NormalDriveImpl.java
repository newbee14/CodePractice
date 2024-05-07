package GeneralPractice.StrategyDesign.Strategy.impl;

import GeneralPractice.StrategyDesign.Strategy.DriveStrategy;

public class NormalDriveImpl implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Normal Drive");
    }

    @Override
    public int getSpeed() {
        return 100;
    }
}

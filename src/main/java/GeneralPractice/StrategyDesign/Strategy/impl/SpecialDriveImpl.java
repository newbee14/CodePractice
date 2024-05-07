package GeneralPractice.StrategyDesign.Strategy.impl;

import GeneralPractice.StrategyDesign.Strategy.DriveStrategy;

public class SpecialDriveImpl implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Special Drive");
    }

    @Override
    public int getSpeed() {
        return 200;
    }
}

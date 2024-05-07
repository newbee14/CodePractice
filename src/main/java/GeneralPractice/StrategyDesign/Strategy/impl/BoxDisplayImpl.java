package GeneralPractice.StrategyDesign.Strategy.impl;

import GeneralPractice.StrategyDesign.Strategy.DisplayStrategy;

public class BoxDisplayImpl implements DisplayStrategy {
    @Override
    public void display() {
        System.out.println("Box Display");
    }
}

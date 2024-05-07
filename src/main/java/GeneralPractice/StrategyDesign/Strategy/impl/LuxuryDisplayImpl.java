package GeneralPractice.StrategyDesign.Strategy.impl;

import GeneralPractice.StrategyDesign.Strategy.DisplayStrategy;

public class LuxuryDisplayImpl implements DisplayStrategy {
    @Override
    public void display() {
        System.out.println("Luxury Display");
    }
}

package GeneralPractice.DecoratorPattern;

public class LUV implements BaseCar {
    @Override
    public int individualCost() {
        System.out.println("LUV costs $20,000");
        return 20000;
    }
}

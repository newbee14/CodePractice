package GeneralPractice.DecoratorPattern;

public class MUV implements BaseCar{
    @Override
    public int individualCost() {
        System.out.println("MUV costs $25,000");
        return 25000;
    }
}

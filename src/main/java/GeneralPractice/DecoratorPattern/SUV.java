package GeneralPractice.DecoratorPattern;

public class SUV implements BaseCar {
    public SUV() {
    }

    @Override
    public int individualCost() {
        System.out.println("SUV costs $30,000");
        return 30000;
    }
}

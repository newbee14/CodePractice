package GeneralPractice.DecoratorPattern;

public class AutomaticTransmission implements CarDecorator {

    BaseCar baseCar;

    int itemCost;

    public int getItemCost() {
        return itemCost;
    }

    public void setItemCost(int itemCost) {
        this.itemCost = itemCost;
    }

    public AutomaticTransmission(BaseCar baseCar) {
        this.baseCar = baseCar;
        setItemCost(10000);
    }

    @Override
    public int individualCost() {
        System.out.println("AutomaticTransmission costs " + (baseCar.individualCost() + 10000));
        return 10000;
    }

    @Override
    public int consolidatedCost() {
        return baseCar.individualCost() + this.itemCost;
    }
}

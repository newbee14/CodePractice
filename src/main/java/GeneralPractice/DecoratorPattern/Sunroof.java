package GeneralPractice.DecoratorPattern;

public class Sunroof implements CarDecorator {

    BaseCar baseCar;

    int itemCost;

    public int getItemCost() {
        return itemCost;
    }

    public void setItemCost(int itemCost) {
        this.itemCost = itemCost;
    }

    public Sunroof(BaseCar baseCar) {
        this.baseCar = baseCar;
        setItemCost(2000);
    }

    @Override
    public int individualCost() {
        System.out.println("BaseCar and Sunroof costs " + (baseCar.individualCost() + 2000));
        return 2000;
    }

    @Override
    public int consolidatedCost() {
        return baseCar.individualCost() + this.itemCost;
    }
}

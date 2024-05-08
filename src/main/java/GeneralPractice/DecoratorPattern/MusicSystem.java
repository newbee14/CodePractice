package GeneralPractice.DecoratorPattern;

public class MusicSystem implements CarDecorator {

    BaseCar baseCar;
    int itemCost;

    public int getItemCost() {
        return itemCost;
    }

    public void setItemCost(int itemCost) {
        this.itemCost = itemCost;
    }

    public MusicSystem(BaseCar baseCar) {
        this.baseCar = baseCar;
        setItemCost(1000);
    }

    @Override
    public int individualCost() {
        System.out.println("BaseCar and MusicSystem costs " + (baseCar.individualCost() + 1000));
        return 1000;
    }

    @Override
    public int consolidatedCost() {
        return baseCar.individualCost() + this.itemCost;
    }
}

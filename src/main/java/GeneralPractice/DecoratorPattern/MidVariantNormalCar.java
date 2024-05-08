package GeneralPractice.DecoratorPattern;

public class MidVariantNormalCar implements CarDecorator {

    BaseCar baseCar;
    int itemCost;

    public int getItemCost() {
        return itemCost;
    }

    public void setItemCost(int itemCost) {
        this.itemCost = itemCost;
    }

    public MidVariantNormalCar(BaseCar baseCar) {
        this.baseCar = baseCar;
        setItemCost(5000);
    }

    @Override
    public int individualCost() {
        System.out.println("MidVariantNormalCar costs " + (baseCar.individualCost() + 5000));
        return baseCar.individualCost() + 5000;
    }

    @Override
    public int consolidatedCost() {
        return baseCar.individualCost() + this.itemCost;
    }
}

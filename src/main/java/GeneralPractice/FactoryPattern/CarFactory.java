package GeneralPractice.FactoryPattern;

public class CarFactory {
    public Car getCar(String carType) {
        if (carType == null) {
            return null;
        }
        if (carType.equalsIgnoreCase("HatchBack")) {
            return new HatchBack();
        } else if (carType.equalsIgnoreCase("Sedan")) {
            return new Sedan();
        } else if (carType.equalsIgnoreCase("SUV")) {
            return new SUV();
        }
        return null;
    }
}

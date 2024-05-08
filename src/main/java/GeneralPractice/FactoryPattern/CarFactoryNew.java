package GeneralPractice.FactoryPattern;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CarFactoryNew {

    final static Map<String, Supplier<Car>> carMap = new HashMap<>();
    static {
        carMap.put("HatchBack", HatchBack::new);
        carMap.put("Sedan", Sedan::new);
        carMap.put("SUV", SUV::new);
    }

    public Car getCar(String car){
        Supplier<Car> carSupplier = carMap.get(car);
        if(carSupplier != null){
            return carSupplier.get();
        }
        throw new IllegalArgumentException("No such car " + car);
    }
}

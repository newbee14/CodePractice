package GeneralPractice.FactoryPattern;

import java.util.HashSet;
import java.util.ServiceLoader;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();

        Car car1 = carFactory.getCar("HatchBack");
        car1.start();
        car1.drive();
        car1.stop();

        Car car2 = carFactory.getCar("Sedan");
        car2.start();
        car2.drive();
        car2.stop();

        Car car3 = carFactory.getCar("SUV");
        car3.start();
        car3.drive();
        car3.stop();
        try {
            new Main().func();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void func() throws ClassNotFoundException {
        Class<?> interfaceClass = Class.forName("GeneralPractice.FactoryPattern.Car");
        Set<Class<?>> implementations = new HashSet<>();
        for (Object service : ServiceLoader.load(interfaceClass)) {
            implementations.add(service.getClass());
        }

        for (Class<?> implementation : implementations) {
            System.out.println("Implementing class: " + implementation.getName());
            // ... do something with the implementation class
        }
    }
}

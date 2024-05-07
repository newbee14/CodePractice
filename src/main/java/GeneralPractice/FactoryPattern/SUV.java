package GeneralPractice.FactoryPattern;

public class SUV implements Car{
    @Override
    public void start() {
        System.out.println("suv started");
    }

    @Override
    public void stop() {
        System.out.println("suv stopped");
    }

    @Override
    public void honk() {
        System.out.println("suv honked");
    }

    @Override
    public void drive() {
        System.out.println("suv is being driven");
    }

    @Override
    public void fillUpGas() {
        System.out.println("suv is being filled up with gas");
    }

    @Override
    public void chargeBattery() {
        System.out.println("suv is being charged");
    }

    @Override
    public void turnOnRadio() {
        System.out.println("suv radio is being turned on");
    }

    @Override
    public void turnOffRadio() {
        System.out.println("suv radio is being turned off");
    }

    @Override
    public void turnOnAC() {
        System.out.println("suv AC is being turned on");
    }

    @Override
    public void turnOffAC() {
        System.out.println("suv AC is being turned off");
    }

    @Override
    public void turnOnHeater() {
        System.out.println("suv heater is being turned on");
    }

    @Override
    public void turnOffHeater() {
        System.out.println("suv heater is being turned off");
    }

    @Override
    public void turnOnHeadlights() {
        System.out.println("suv headlights are being turned on");
    }

    @Override
    public void turnOffHeadlights() {
        System.out.println("suv headlights are being turned off");
    }
}

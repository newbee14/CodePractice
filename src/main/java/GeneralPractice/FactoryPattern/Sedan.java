package GeneralPractice.FactoryPattern;

public class Sedan implements Car{
    @Override
    public void start() {
        System.out.println("Sedan started");
    }

    @Override
    public void stop() {
        System.out.println("Sedan stopped");
    }

    @Override
    public void honk() {
        System.out.println("Sedan honked");
    }

    @Override
    public void drive() {
        System.out.println("Sedan is being driven");
    }

    @Override
    public void fillUpGas() {
        System.out.println("Sedan is being filled up with gas");
    }

    @Override
    public void chargeBattery() {
        System.out.println("Sedan is being charged");
    }

    @Override
    public void turnOnRadio() {
        System.out.println("Sedan radio is being turned on");
    }

    @Override
    public void turnOffRadio() {
        System.out.println("Sedan radio is being turned off");
    }

    @Override
    public void turnOnAC() {
        System.out.println("Sedan AC is being turned on");
    }

    @Override
    public void turnOffAC() {
        System.out.println("Sedan AC is being turned off");
    }

    @Override
    public void turnOnHeater() {
        System.out.println("Sedan heater is being turned on");
    }

    @Override
    public void turnOffHeater() {
        System.out.println("Sedan heater is being turned off");
    }

    @Override
    public void turnOnHeadlights() {
        System.out.println("Sedan headlights are being turned on");
    }

    @Override
    public void turnOffHeadlights() {
        System.out.println("Sedan headlights are being turned off");
    }
}

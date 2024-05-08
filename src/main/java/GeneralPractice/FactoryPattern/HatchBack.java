package GeneralPractice.FactoryPattern;

public class HatchBack implements Car{
    @Override
    public void start() {
        System.out.println("HatchBack started");
    }

    @Override
    public void stop() {
        System.out.println("HatchBack stopped");
    }

    @Override
    public void honk() {
        System.out.println("HatchBack honked");
    }

    @Override
    public void drive() {
        System.out.println("HatchBack is being driven");
    }

    @Override
    public void fillUpGas() {
        System.out.println("HatchBack is being filled up with gas");
    }

    @Override
    public void chargeBattery() {
        System.out.println("HatchBack is being charged");
    }

    @Override
    public void turnOnRadio() {
        System.out.println("HatchBack radio is being turned on");
    }

    @Override
    public void turnOffRadio() {
        System.out.println("HatchBack radio is being turned off");
    }

    @Override
    public void turnOnAC() {
        System.out.println("HatchBack AC is being turned on");
    }

    @Override
    public void turnOffAC() {
        System.out.println("HatchBack AC is being turned off");
    }

    @Override
    public void turnOnHeater() {
        System.out.println("HatchBack heater is being turned on");
    }

    @Override
    public void turnOffHeater() {
        System.out.println("HatchBack heater is being turned off");
    }

    @Override
    public void turnOnHeadlights() {
        System.out.println("HatchBack headlights are being turned on");
    }

    @Override
    public void turnOffHeadlights() {
        System.out.println("HatchBack headlights are being turned off");
    }
}

package GeneralPractice.FunctionalInterface;

@FunctionalInterface
public interface SampleFuncI {
    int doSomething(int a);

    default int addNumbers(int a , int b) {
        System.out.println("addNumbers");
        return a + b;
    }
    static int substractNumbers(int a , int b) {
        System.out.println("Doing something else");
        return a - b;
    }
}

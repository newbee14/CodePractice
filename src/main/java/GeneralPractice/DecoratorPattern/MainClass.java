package GeneralPractice.DecoratorPattern;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        BaseCar car = new LUV();
        int finalCost= new Sunroof(new MusicSystem(car)).consolidatedCost();
        System.out.println(finalCost);
        try{
            new MainClass().acceptUserInput();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void acceptUserInput() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object

        String carType = sc.nextLine();
        String[] decorations=null;
        decorations = sc.nextLine().split(" ");
        int finalCost = 0;
        //Create a car object based on user input without using if-else or switch-case statements using reflection
        Class theClass = Class.forName("DecoratorPattern."+carType);
        BaseCar car = (BaseCar) theClass.newInstance();
        if(decorations==null || decorations.length==0 ){
            System.out.println(car.individualCost());
            return;
        }
        finalCost= car.individualCost();
        for (String decoration : decorations) {
            Class<?> theDecorationClass = Class.forName("DecoratorPattern."+decoration);
            CarDecorator carDecorator = (CarDecorator) theDecorationClass.getConstructor(BaseCar.class).newInstance(car);
            finalCost += carDecorator.individualCost();
        }
        System.out.println("finalCost is "+finalCost);
    }
}

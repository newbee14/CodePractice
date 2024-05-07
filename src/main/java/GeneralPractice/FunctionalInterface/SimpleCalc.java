package GeneralPractice.FunctionalInterface;


import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SimpleCalc {


    public static void main(String[] args) {
//        SampleFuncI hello_world = () -> System.out.println("Hello World");
//        SampleFuncI hello = () -> System.out.println("Hello");
//        hello_world.doSomething();
//        hello.doSomething();
//        System.out.println(hello_world.addNumbers(1, 2));
//        System.out.println(SampleFuncI.substractNumbers(1, 2));

//        Consumer<String> printString = (String s) -> System.out.println(s.concat(" Hello"));
        Consumer<Long> printString = (Long s) -> System.out.println(String.valueOf(s).concat(" Hello"));
//        Consumer<String> print = (String s) -> System.out.println(s);
//        Consumer<String> printAnodtherString = (String s) -> System.out.println(s.concat(" World"));
//        print.andThen(printString).andThen(printAnodtherString).accept("123");

//        Predicate<String> isStringEmpty = (String s) -> s.isEmpty();
//        Predicate<String> isStringNotEmpty = (String s) -> !s.isEmpty();
//        Predicate<Integer> isIntEmpty = (Integer s) -> s>0;

//        System.out.println(isStringNotEmpty.and(isStringNotEmpty.negate()).test("123"));
//        System.out.println(isStringNotEmpty.or(isStringNotEmpty.negate()).test("123"));
//        System.out.println(isStringNotEmpty.test("123"));
//        System.out.println(isStringNotEmpty.negate().test("123"));
//        boolean check= Predicate.isEqual(isIntEmpty.test(1)).test(isIntEmpty.test(2));
//        System.out.println(check);
//        System.out.println(isStringEmpty.test("123"));
//        isIntEmpty.negate().test(1);
//        Integer a=12;
//        String b="12";
//        System.out.println(Predicate.isEqual(a).test(Integer.parseInt(b)));

//        SampleFuncI printString = (int s) -> s+10;
//        SampleTriFunction<Object, Integer, Integer, Integer> add =
//                (Integer a, Integer b, Integer printString123) -> a + b + printString.doSomething(1);
//
//        System.out.println(add.process(1,2,3));
//        Supplier<String> supplier = () -> "Hello";

        List<Integer> list= Arrays.asList(1,2,3,4,500,6,7,8,9,10);
        List<List<Integer>> listOfList= Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4));

//        list.stream().filter((Integer i) -> i % 2 == 0).findAny().orElseGet(() -> Integer.valueOf("Hello"));
//        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
//        list.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).forEach(System.out::println);
//        list.stream().map(x-> String.valueOf(x)).collect(Collectors.toList());
//        listOfList.stream().map().collect(Collectors.toList()).forEach(System.out::println);
//        Collections.singletonList(list);
        CustomerPojo customerPojo= new CustomerPojo();
        customerPojo.setId(1L);
        customerPojo.setName("Hello");
        customerPojo.setAddress("World");
        customerPojo.setEmail("some@gmail.com");
        customerPojo.setPhoneNumber("1234567890");
        Optional.ofNullable(customerPojo.getId()).ifPresent(printString);
        Arrays.asList(customerPojo).stream().map(CustomerPojo::getId).collect(Collectors.toList()).forEach(printString);

    }
    public void test(String... a){

    }
}

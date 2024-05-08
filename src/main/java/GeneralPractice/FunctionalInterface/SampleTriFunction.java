package GeneralPractice.FunctionalInterface;

import java.util.function.Predicate;

@FunctionalInterface
public interface SampleTriFunction<W ,T, U, V> {
    W process (T t, U u, V v);

    default boolean Predicate(T t, U u, V v) {
        System.out.println("addNumbers");
        return Predicate.isEqual(t).test(u);
    }
}

package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * Java has a lot of functional interfaces in the java.util.function package.
 * Instead of creating our own functional interface, we can use the existing ones.
 * For example, the {@link Operation} we used in {@link MoreLambdaExpressions::calculator} method,
 * is already available in the java.util.function package as the BinaryOperator<T> interface.
 */
public class FunctionalInterfaceConsumerAndPredicate {

    // Previous Implementation
//    public static <T> T calculator(T t1, T t2, Operation<T> fn) {
//        T result = fn.operate(t1, t2);
//        System.out.println("Result of operation: " + result);
//        return result;
//    }

    public static <T> T calculator(T t1, T t2, BinaryOperator<T> fn) {
        T result = fn.apply(t1, t2);
        System.out.println("Result of operation: " + result);
        return result;
    };

    /**
     * In the java.util.function package, there are a lot of functional interfaces.
     * They're categorized into 4 categories:
     * 1. Supplier<T> -- doesn't take any argument, but returns a value of type T
     *    - Method signature: T get();
     *    - e.g. Supplier<String> supplier = () -> "Hello World!";
     *           String result = supplier.get();
     *
     * 2. Consumer<T> -- takes an argument of type T, but doesn't return anything
     *    - Method signature: void accept(T t);
     *    - e.g. Consumer<String> consumer = s -> System.out.println(s);
     *           consumer.accept("Hello World!");
     *
     * 3. Predicate<T> -- takes an argument of type T, and returns a boolean value
     *    - Method signature: boolean test(T t);
     *    - e.g. Predicate<String> predicate = s -> s.length() > 5;
     *           boolean result = predicate.test("Hello World!");
     *
     * 4. Function<T, R> -- takes an argument of type T, and returns a value of type R
     *    - Method signature: R apply(T t);
     *    - e.g. Function<String, Integer> function = s -> s.length();
     *           int result = function.apply("Hello World!");
     *
     */

    /**
     * Types of Consumer Interface
     * 1. Consumer<T> -- takes an argument of type T, but doesn't return anything
     *    - Method signature: void accept(T t);
     *    - e.g. Consumer<String> consumer = s -> System.out.println(s);
     *           consumer.accept("Hello World!");
     *
     * 2. BiConsumer<T, U> -- takes two arguments of type T and U, but doesn't return anything
     *    - Method signature: void accept(T t, U u);
     *    - e.g. BiConsumer<String, String> biConsumer = (s1, s2) -> System.out.println(s1 + s2);
     *           biConsumer.accept("Hello ", "World!");
     *
     */

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }

    /**
     * Types of Predicate Interface
     * 1. Predicate<T> -- takes an argument of type T, and returns a boolean value
     *    - Method signature: boolean test(T t);
     *    - e.g. Predicate<String> predicate = s -> s.length() > 5;
     *           boolean result = predicate.test("Hello World!");
     *           System.out.println(result); // prints true
     * 2. BiPredicate<T, U> -- takes two arguments of type T and U, and returns a boolean value
     *    - Method signature: boolean test(T t, U u);
     *    - e.g. BiPredicate<String, String> biPredicate = (s1, s2) -> s1.length() > s2.length();
     *           boolean result = biPredicate.test("Hello", "World!");
     *           System.out.println(result); // prints true
     */

    public static <T> List<T> filter(List<T> list, Predicate<? super T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 1. Using the Consumer Interface
        System.out.println("Using the Consumer Interface");
        List<double[]> coords = Arrays.asList(
                new double[]{47.2160, -95.2348},
                new double[]{29.1566, -89.2495},
                new double[]{35.1556, -90.0659}
        );

        coords.forEach(s -> System.out.println(Arrays.toString(s)));

        // Defining the BiConsumer
        BiConsumer<Double, Double> p1 = (lat, lon) -> System.out.printf("[lat:%.3f long:%.3f]%n", lat, lon);

        double[] firstPoint = coords.get(0);

        // Using the `p1` BiConsumer here
        processPoint(firstPoint[0], firstPoint[1], p1);

        System.out.println("--------------------");

        // print all the coordinates using BiConsumer `p1` as follows:
        coords.forEach(s -> processPoint(s[0], s[1], p1));

        // We can define the BiConsumer directly in the forEach method as follows:
        coords.forEach(s -> processPoint(s[0], s[1], (lat, lon) -> System.out.printf("[lat:%.3f long:%.3f]%n", lat, lon)));
        // the above statement is same as: coords.forEach(s -> processPoint(s[0], s[1], p1));


        // 2. Using the Predicate Interface

        System.out.println("Using the Predicate Interface");
        List<String> list = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo");

        // Defining the Predicate
        Predicate<String> p2 = s -> s.equalsIgnoreCase("delta");

        // Using the Predicate
        List<String> result = filter(list, p2);

        System.out.println(result); // [delta]

        // We can define the Predicate directly in the filter method as follows:
        List<String> result2 = filter(list, s -> s.equalsIgnoreCase("delta"));
        System.out.println(result2); // [delta]

        // There are inbuilt methods in List interface like `removeIf` which takes a Predicate as an argument.
        // The definition of `removeIf` method is as follows:
        // default boolean removeIf(Predicate<? super E> filter) {
        //     Objects.requireNonNull(filter);
        //     boolean removed = false;
        //     final Iterator<E> each = iterator();
        //     while (each.hasNext()) {
        //         if (filter.test(each.next())) {
        //             each.remove();
        //             removed = true;
        //         }
        //     }
        //     return removed;
        // }

        // We can use the `removeIf` method as follows:
        List<String> list2 = new ArrayList<>(list);

        list2.removeIf(s -> s.equalsIgnoreCase("delta"));
        System.out.println(list2); // [alpha, bravo, charlie, echo] // "delta" is removed

        // Another exercise
        list2.addAll(Arrays.asList("echo", "easy", "earnest"));
    }
}

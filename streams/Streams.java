package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Streams {
    public static void main(String[] args) {
        System.out.println("Hello, World! (Streams)");

        /*
        * NOTE: Streams are not a data structure, but a way to process data.
        *       The best way to understand how streams work, is to put debug points
        *       at appropriate places and see how the data flows.
        * */

        /*
        * One good thing about streams is that we can do parallel processing with them in an easier manner,
        * compared to looping structures.
        *
        * We can use stream().parallel() or use List::parallelStream to make the processing parallel.
        * */

        /*
        * If we've a List<Object> as follows:
        *   { "d", 7, "b", 3, 8, "z", 9 }
        * then, we can use streams to capitalize the strings and ignore the integers.
        * The processing will happen on each element inside the List.
        * */

        List<String> stringList = Arrays.asList("d", "7", "b", "3", "8", "z", "9");

        System.out.println("-----TraditionalLoopingStructure-----");
        // Traditional looping structure
        List<Integer> numbers = new ArrayList<>();

        // This will fully iterate and complete first
        stringList.forEach(s -> {
            try {
                numbers.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                System.out.println("Not a number: " + s);
            }
        });

        List<Integer> squareList = new ArrayList<>();

        // Then this will also iterate on the entire list
        numbers.forEach(n -> squareList.add(n * n));

        System.out.println(numbers);
        System.out.println(squareList);

        /*
        * Output for the above code:
        *
        * -----TraditionalLoopingStructure-----
        * Not a number: d
        * Not a number: b
        * Not a number: z
        * [7, 3, 8, 9]
        * [49, 9, 64, 81]
        * */


        System.out.println("-----Streams-----");
        // Streams - each and every element is processed individually till the end-state is reached.
        stringList.stream()
                .map(s -> {
                    try {
                        return Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        System.out.println("Not a number: " + s);
                        return null;
                    }
                })
                .filter(Objects::nonNull) // .filter(i -> Objects.nonNull(i)) // also works
                .map(n -> {               // .map(n -> n * n) // also works
                    return n * n;
                })
                .forEach(System.out::println);

        /*
        * Output for the above code:
        *
        * -----Streams-----
        * Not a number: d
        * 49
        * Not a number: b
        * 9
        * 64
        * Not a number: z
        * 81
        *
        * */

    }
}

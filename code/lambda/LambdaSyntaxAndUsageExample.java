package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaSyntaxAndUsageExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList(
                "alpha", "bravo", "charlie", "delta", "echo")
        );

        // Using enhanced for loop
        for (String s : list) {
            System.out.println(s);
        }

        // Using forEach method
        list.forEach(s -> System.out.println(s)); // this is valid
        list.forEach((s) -> System.out.println(s)); // this is also valid
        list.forEach((String s) -> System.out.println(s)); // this is also valid
//        list.forEach(String s -> System.out.println(s)); // this is invalid, because we need to enclose the parameter in parentheses

//        String myString = "nato"; // this is invalid, because myString is used inside the scope of lambda expression
        String prefix = "nato";
        // this is also valid (because we're using a block inside a lambda expression)
        list.forEach(myString -> {
            char firstCharacter = myString.charAt(0);
            System.out.println(prefix + " " + myString + " means " + firstCharacter);
        });

        System.out.println(prefix); // this is valid, because prefix is defined outside the scope of lambda expression
//        prefix = "nato2"; // this is not a good practice, because we're changing the value of prefix, which is defined outside the scope of lambda expression
//                          // We'll learn more about it in deferred lambda expressions.

        // We cannot have the same named variable outside the scope of lambda expression
//        System.out.println(myString); // this is invalid, because myString is not defined outside the scope of lambda expression
    }
}

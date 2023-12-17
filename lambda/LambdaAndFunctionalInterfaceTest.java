package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// @FunctionalInterface -- we cannot annotate with this annotation, as it's not a functional interface,
// It has 2 abstract methods, instead of 1.
interface EnhancedComparator<T> extends Comparator<T> {
    int secondCompare(T t1, T t2);
}

public class LambdaAndFunctionalInterfaceTest {
    private static class Person {
        private final String firstName;
        private final String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public String toString() {
            return "\nPerson{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>(Arrays.asList(
                new Person("John", "Doe"),
                new Person("Aaron", "Powell"),
                new Person("Steve", "Smith"),
                new Person("Claire", "Berets"),
                new Person("Mathew", "Doe")
        ));

        /*
        // Anonymous class
        Comparator<Person> firstNameComparator = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getFirstName().compareTo(p2.getFirstName());
            }
        };

        persons.sort(firstNameComparator);
        System.out.println(persons);
        */

        /*
        // Anonymous Class
        // Instead of creating an anonymous class and assigning it to a variable,
        // we can directly pass (while creating the object) the anonymous class to the method.

        // This achieves the same result as the above commented code.
        persons.sort(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getFirstName().compareTo(p2.getFirstName());
            }
        });
        System.out.println(persons);
        */

        // Lambda Expression
        // Instead of any anonymous classes, we can use lambda expressions as follows
        // to achieve the same result as the above commented code.
        persons.sort((p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName())); // this is a single line result
        System.out.println(persons);


        // Lambda Expressions only work with Functional Interfaces.
        // Functional interfaces are interfaces with only one abstract method.
        // If there is more than 1 abstract method, then the compiler will throw an error.
        // Example of a functional interface is Comparator<T> interface.

        // Above, there's am EnhancedComparator interface, which extends Comparator<T> interface.
        // And EnhancedComparator interface has 2 abstract methods.
        // So, EnhancedComparator is not a functional interface, and it will throw an error.
        // We can use @FunctionalInterface annotation, but it'll not help in this case,
        // as the compiler will still throw an error.

        // this anonymous class is not a functional interface, as it has 2 abstract methods.
        // and so, we cannot use lambda expressions with it.
        persons.sort(new EnhancedComparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                int result = p1.getLastName().compareTo(p2.getLastName());

                // if they've same lastnames, then sort by firstnames
                return result == 0 ? secondCompare(p1, p2) : result;
            }

            @Override
            public int secondCompare(Person p1, Person p2) {
                return p1.getFirstName().compareTo(p2.getFirstName());
            }
        });
        System.out.println(persons);

        // Lambda expression below is directly mapping to Comparator<T> interface's compare method.
        // It's not mapping to EnhancedComparator<T> interface's secondCompare method,
        // EnhancedComparator<T> is not a functional interface.
        /*
        persons.sort((p1, p2) -> {
            int result = p1.getLastName().compareTo(p2.getLastName());

            // if they've same lastnames, then sort by firstnames
            return result == 0 ? secondCompare(p1, p2) : result; // error: cannot find symbol secondCompare
        });
        */
    }
}

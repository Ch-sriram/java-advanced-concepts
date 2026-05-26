package lambda;

public class MoreLambdaExpressions {
    public static <T> T calculator(T t1, T t2, Operation<T> function) {
        T result = function.operate(t1, t2);
        System.out.println("Result of operation: " + result);
        return result;
    }

    public static void main(String[] args) {
        calculator(10, 20, (a, b) -> a + b); // valid

        // If type is mentioned in the lambda expression,
        // then it should be mentioned for all the parameters as shown below:
        calculator(10, 20, (Integer a, Integer b) -> a + b); // valid

        // error: incompatible types: unexpected return value, sout returns void
//        int result3 = calculator(10, 20, (a, b) -> System.out.println(a + b));

        // block lambda expression is valid
        calculator(10, 20, (a, b) -> {
            System.out.println(a + b);
            return a + b; // 'return' keyword is mandatory for block lambda expression
        });

        // We can also do other calculations using the same calculator method
        calculator(10, 20, (a, b) -> a - b);
        calculator(10, 20, (a, b) -> a * b);
        calculator(10f, 20f, (a, b) -> a / b);

        // error: calculator is returning float, but the result is being stored in int
//        int result8 = calculator(10f, 20f, (a, b) -> a % b);

        calculator(10, 20, (a, b) -> a % b); // valid: 10 % 20 = 10

        // valid -> All types are same, which is String
        calculator("hello", "world", (a, b) -> a.toUpperCase() + ", " + b.toUpperCase() + "!");
    }
}

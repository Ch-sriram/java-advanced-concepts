package exceptions.Throw;

/**
 * Whenever an exception is raised, the main method implicitly creates an object of the respective exception and then hands
 * over that object to JVM.
 * 
 * But, we can always use the "throw" keyword to explicitly handover/throw the exception to the JVM.
 */

// class Demo {
//     public static void main(String[] args) {
//         System.out.println(10 / 0);
//         // Whenever an exception is raised, the main method implicitly creates an object of the respective exception and 
//         // then hands over that object to JVM.
//     }
// }

/**
 * Output for the code above:
 * -------------------------
 * Exception in thread "main" java.lang.ArithmeticException: / by zero
 *      at exceptions.Throw.Demo.main(ThrowExample.java:12)
 */

class ThrowExample {
    public static void main(String[] args) throws ArithmeticException {
        ArithmeticException ex = new ArithmeticException("Division by zero");
        throw ex; // we explicitly threw the exception to the JVM
        /**
         * The JVM has to handle the thrown exception by printing the message we just described for the exception above, 
         * which is "Division by zero".
         */

        // Now, whenever we throw an exception to the JVM, we generally tell the compiler that "this particular method 
        // can throw this certain Exception" and for that, we use the "throws" keyword when defining the method as shown in
        // line 26.
    }
}

/**
 * Output for the code above:
 * -------------------------
 * Exception in thread "main" java.lang.ArithmeticException: Division by zero
 *      at exceptions.Throw.Demo.main(ThrowExample.java:27)
 */
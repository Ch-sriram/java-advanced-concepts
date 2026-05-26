package exceptions.Throws;

/**
 * the keyword "throws" is used to tell the compiler (javac) that this particular method can throw this particular exception
 * and one more core functionality of the "throws" keyword is the delegation of responsibility of handling an exception to 
 * the caller.
 * 
 * We will see the examples below.
 */

// In general, Thread.sleep(1000); throws InterruptedException internally, and it can be handled in 1 of the foll. 2 ways:
//  1. Using the try{} catch{} block and,
//  2. Delegating the responsibility to handle the exception raised, to the calling method.

/* When the exception is unhandled, we'd get a Compilation Error */
// class Demo {
//     public static void main(String[] args) {
//         doStuff();
//     }

//     public static void doStuff() {
//         doMoreStuff();
//     }

//     public static void doMoreStuff() {
//         Thread.sleep(6000); // Internally sleep() throws InterruptedException, which needs to be handled.
//         // Therefore, this method won't be executed because the exception hasn't been handled properly.
//     }
// }

/**
 * Output for the code above:
 * -------------------------
 * Exception in thread "main" java.lang.Error: Unresolved compilation problem:
 *      Unhandled exception type InterruptedException
 *      at exceptions.Throws.Demo.doMoreStuff(ThrowsExample.java:26)
 *      at exceptions.Throws.Demo.doStuff(ThrowsExample.java:22)
 *      at exceptions.Throws.Demo.main(ThrowsExample.java:18)
 */

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Now, we can handle the exception in 4 ways in the scenario we've seen above. We will see each case of handling as follows:

/* Case I: Using try{} catch{} where the exception occurs, i.e., inside doMoreStuff() method */
// class Demo {
//     public static void main(String[] args) {
//         doStuff();
//     }

//     public static void doStuff() {
//         doMoreStuff();
//     }

//     public static void doMoreStuff() {
//         // We can handle the exception right here using try{} catch{} block
//         try {
//             Thread.sleep(6000);
//             System.out.println("Printed after 6 seconds");
//         } catch (InterruptedException ex) {
//             ex.printStackTrace();
//         }
//     }
// }
/**
 * Output for the code above (after 6 seconds):
 * -------------------------------------------
 * Printed after 6 seconds
 */




/* Case II: doMoreStuff() method can delegate the exception to be handled by its caller which is doStuff() method 
            using the "throws" keyword and inside doStuff() method, we can handle the exception using try{}-catch{} block.
*/
// class Demo {
//     public static void main(String[] args) {
//         doStuff();
//     }

//     public static void doStuff() {
//         try {
//             doMoreStuff();
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }
//     }

//     public static void doMoreStuff() throws InterruptedException {
//         Thread.sleep(6000);
//         System.out.println("Printed after 6 seconds");
//     }
// }
/**
 * Output for the code above (after 6 seconds):
 * -------------------------------------------
 * Printed after 6 seconds
 */




/**
 * Case III: doMoreStuff() method can delegate the handling of the exception to be handled by its calling method which is 
 *           doStuff() method. Now, doStuff() method can also delegate the exception it's supposed to handle to its calling
 *           method which is the main() method. Inside the main() method, we can handle the exception using try{}-catch{}.
 */
// class Demo {
//     public static void main(String[] args) {
//         try {
//             doStuff();
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }
//     }

//     public static void doStuff() throws InterruptedException {
//         doMoreStuff();
//     }

//     public static void doMoreStuff() throws InterruptedException {
//         Thread.sleep(6000);
//         System.out.println("Printed after 6 seconds");
//     }
// }
/**
 * Output for the code above (after 6 seconds):
 * -------------------------------------------
 * Printed after 6 seconds
 */



/**
 * Case IV: doMoreStuff() method can delegate the handling of the exception to its caller, which is doStuff() method.
 *          doStuff() method can delegate the handling of the exception to its respective caller which is the main() method.
 *          main() method can also delegate the handling of the exception to its caller, which is the JVM.
 *          And finally, JVM will internally handle the exception implicitly. The code below depicts this case.
 */
class ThrowsExample {
    public static void main(String[] args) throws InterruptedException {
        doStuff();
    }

    public static void doStuff() throws InterruptedException {
        doMoreStuff();
    }

    public static void doMoreStuff() throws InterruptedException {
        Thread.sleep(6000);
        System.out.println("Printed after 6000 milliseconds");
    }
}
/**
 * Output of the code above (after 6 seconds):
 * ------------------------------------------
 * Printed after 6000 milliseconds
 */
package exceptions.Finally;

/**
 * Suppose we are trying to connect to a Database (DB) and for that, the steps are:
 *  1. Open the DB.
 *  2. Process Information.
 *  3. Close the DB.
 * So, when we do all of these steps, if we try to do these steps in only try{...} catch{...} blocks, in that case, the 
 * following will happen:
 */

// class Demo {
//     public static void main(String[] args) {
//         try {
//             System.out.println("1. Open the DB Connection");
//             System.out.println("2. Process Information from/to the DB");
//             System.out.println(10/0);
//             System.out.println("3. Close the DB"); // this line will never be executed
//         } catch (ArithmeticException e) {
//             e.printStackTrace();
//         }
//     }
// }

/**
 * Output we get from the code above: (which is commented)
 * 1. Open the DB Connection
 * 2. Process Information from/to the DB
 * java.lang.ArithmeticException: / by zero
 *      at exceptions.Finally.Demo.main(FinallyExample.java:17)
 */

/**
 * Now, to safely close the DB connection (which is code for cleaning-up) which needs to be closed no matter what, 
 * even if there's an exception in the code, we need to put such clean-up code inside the "finally {...}" block.
 * 
 * The code inside the "finally {...}" block runs no matter what exception(s) occur in the code.
 * The only time the code inside a finally{} block doesn't run would be when we shutdown the JVM deliberately using 
 * "System.exit(0);" in the try{} block.
 */

class FinallyExample {
    public static void main(String[] args) {
        try {
            System.out.println("1. Open the DB Connection");
            System.out.println("2. Process Information from/to the DB");
            System.out.println(10/0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } finally {
            System.out.println("3. Close the DB"); // this line will be executed no matter what. It won't be executed iff System.exit(0) is called inside the try{}
        }
    }
}

/**
 * Output:
 * ------ 
 * 1. Open the DB Connection
 * 2. Process Information from/to the DB
 * java.lang.ArithmeticException: / by zero
 *      at exceptions.Finally.FinallyExample.main(FinallyExample.java:47)
 * 3. Close the DB
 */
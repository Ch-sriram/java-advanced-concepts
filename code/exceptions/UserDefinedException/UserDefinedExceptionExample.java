package exceptions.UserDefinedException;

/**
 * We can create our own custom exceptions like InsufficientBalanceException or UserIDNotFoundException, etc.
 * 
 * To do that, we have to follow the 2 steps given below:
 *  1. Define a class (say "InsufficientBalanceException") which extends the RuntimeException
 *  2. Create a parameterized constructor which takes in a message of String type and simply calls the super() class' 
 *     constructor by passing the message sent to it.
 * 
 * Example below.
 */

import java.util.Scanner;

class InsufficientBalanceException extends RuntimeException {
    /**
     * Exception raised when the balance is below $500
     */
    private static final long serialVersionUID = 1L;

    public InsufficientBalanceException(String message) {
        super(message); // calling the constructor of the parent class which is constructor of
                        // RuntimeException
    }
}


public class UserDefinedExceptionExample {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("Type in a number: ");
            int balance = scan.nextInt();
            if (balance < 500) {
                InsufficientBalanceException iex = new InsufficientBalanceException(
                        "Your A/C balance is low (less than $500). Please check your balance.");
                throw iex;
            } else {
                System.out.println("BALANCE is " + balance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scan.close();
        }
    }
}

/**
 * Output #1 (after user input):
 * -----------------------------
 * Type in a number: 499
 * exceptions.UserDefinedException.InsufficientBalanceException: Your A/C balance is low (less than $500). Please check your balance.
 *      at exceptions.UserDefinedException.UserDefinedExceptionExample.main(UserDefinedExceptionExample.java:22)
 * 
 * 
 * Output #2 (after user input):
 * -----------------------------
 * Type in a number: 500
 * BALANCE is 500
 */
package exceptions.TryCatch;

import java.util.Arrays;

public class TryCatchExample {
    public static void main(String[] args) {
        try {
            /** Uncomment the lines below to see the Exceptions being handled */

            // System.out.println(10 / 0); // ArithmeticException
            
            int[] arr = { 1, 2, 4 };
            System.out.println(Arrays.toString(arr)); // [1, 2, 4]; if we simply call "System.out.println(arr)", we would simply print the reference of arr
            // System.out.println(arr[10]); // ArrayIndexOutOfBoundsException

            String str = "abc";
            System.out.println(str); // abc
            // System.out.println(str.charAt(10)); // StringIndexOutOfBoundsException

            String s = null;
            System.out.println(s); // There's no output
            // System.out.println(s.charAt(10)); // NullPointerException

            String numString = "ten";
            System.out.println(Integer.parseInt(numString)); // NumberFormatException
        } catch (ArithmeticException | NullPointerException | NumberFormatException ex) {
            ex.printStackTrace(); // "java.lang.ArithmeticException: / by zero" at exceptions.TryCatchExample.main(TryCatchExample.java:6)
            // System.out.println(ex); // same as "System.out.println(ex.toString());" // "java.lang.ArithmeticException: / by zero"
            // System.out.println(ex.getMessage()); // "/ by zero"
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
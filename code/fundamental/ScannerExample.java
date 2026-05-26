package fundamental;

import java.util.Scanner;

public class ScannerExample {
  public static void main(String[] args) {
    String input = "Car 10 20.4 true";

    Scanner ss = new Scanner(input);

    String car = ss.next();
    int xx = ss.nextInt();
    double yy = ss.nextDouble();
    boolean zz = ss.nextBoolean();
    System.out.println(car);
    System.out.println(xx);
    System.out.println(yy);
    System.out.println(zz);

    ss.close();

    Scanner s = new Scanner(System.in);

    System.out.print("Enter an integer: ");
    int x = s.nextInt();

    System.out.print("Enter a float: ");
    float y = s.nextFloat();

    System.out.print("Enter a double: ");
    double z = s.nextDouble();

    System.out.print("Enter a string: ");
    String str = s.next();

    System.out.println(x);
    System.out.println(y);
    System.out.println(z);
    System.out.println(str);

    s.close();
  }
}

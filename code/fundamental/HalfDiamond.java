package fundamental;

import java.util.Scanner;

public class HalfDiamond {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    scan.close();

    // for (int i = 1; i <= n; ++i) {
    // // i: 1 -> 2 -> 3
    // for (int j = 1; j <= i; ++j) {
    // // j: 1 -> 2
    // for (int k = 1; k <= j; ++k) {
    // // k: 1 -> 2
    // System.out.println("i = " + i + "; j = " + j + "; k = " + k);
    // }

    // }

    // }

    for (int i = 1; i <= n; ++i) {
      for (int j = 1; j <= i; ++j) {
        System.out.print("*");
      }
      System.out.println();
    }

    for (int i = 1; i < n; ++i) { // n = 5; 1 -> n-1 => 4
      for (int j = n; j > i; --j) { // j = 5; 5 >= 2;
        System.out.print("*");
      }
      System.out.println();
    }

  }

}

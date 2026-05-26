package fundamental;

import java.util.Scanner;

public class DiamondPattern {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt(); // n = 3
    s.close();

    int totalIterations = 2 * n; // 6
    int middle = totalIterations / 2; // 6 / 2 = 3
    for (int i = 0; i <= totalIterations; ++i) {
      // Stars in the top half of the diamond
      if (i < middle) { // i: 0, 1, 2
        for (int j = 0; j < n - i; j++) {
          System.out.print(" ");
        }
        for (int j = 0; j < 2 * i + 1; j++) {
          System.out.print("*");
        }
      } else if (i == middle) { // Stars in the middle of the diamond
        // i: 3
        for (int j = 0; j < 2 * n + 1; ++j) {
          System.out.print("*");
        }
      } else { // Stars in the bottom half of the diamond
        // i > 4: 4, 5, 6
        for (int j = 1; j <= i - n; j++) {
          System.out.print(" ");
        }
        int x = 2 * n - i; // 4 -> 2, 5 -> 1, 6 -> 0
        for (int j = 0; j < 2 * x + 1; ++j) {
          System.out.print("*");
        }
      }
      System.out.println();
    }
  }
}

package fundamental;

public class InfiniteLoopExample {

  public static void main(String[] args) {
    System.out.println("Infinite for loop:");
    int i = 0;
    // for (;;) {
    // System.out.println(i++);
    // }

    while (true) {
      System.out.println(--i);
    }
  }
}

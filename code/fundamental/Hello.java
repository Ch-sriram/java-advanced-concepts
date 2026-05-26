package fundamental;

public class Hello {
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Hello World!");
    } else {
      for (int i = 0; i < args.length; ++i)
        System.out.print(args[i] + " ");
    }
  }
}

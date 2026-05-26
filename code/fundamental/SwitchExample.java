package fundamental;

public class SwitchExample {
  public static void main(String[] args) {
    int day = 2;
    switch (day) {
      case 1: {
        System.out.println("Monday");
        break;
      }
      case 2: {
        System.out.println("Tuesday");
        break;
      }
      case 3: {
        System.out.println("Wednesday");
        break;
      }
      case 4: {
        System.out.println("Thursday");
        break;
      }
      case 5: {
        System.out.println("Friday");
        break;
      }
      case 6: {
        System.out.println("Saturday");
        break;
      }
      case 7: {
        System.out.println("Sunday");
        break;
      }
      default: {
        System.out.println("No day exists for day no. " + day);
      }
    }

    switch (day) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5: {
        System.out.println("Weekday 😔");
        break;
      }
      case 6:
      case 7: {
        System.out.println("Yay, it's Weekend! 😘");
        break;
      }
      default: {
        System.out.println("Given day no. " + day + " is invalid!");
      }
    }
  }
}

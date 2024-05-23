package reflection.ReflectionDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class MyClass {
  private MyClass() {
    System.out.println("MyClass Object Created!");
  }

  public String toString() {
    return "MyClass Object";
  }
}

public class ReflectionDemo {
  public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    // MyClass myClass = new MyClass(); // error: MyClass() has private access in MyClass

    /**
     * We can make use of `Class.forName` to create an object of the class as follows:
     */

    // Here, the fully qualified name of the class is passed as a string.
    Class<?> clazz = Class.forName("reflection.ReflectionDemo.MyClass");
    Constructor<?> clazzConstructor = clazz.getDeclaredConstructor(); // This will get the private constructor
    clazzConstructor.setAccessible(true); // This is required to access the private constructor

    // Create the instance of MyClass -- This will print "MyClass Object Created!"
    Object myClass = clazzConstructor.newInstance(); // MyClass Object Created!
    System.out.println(myClass); // MyClass Object

    // We can also typecase our object to MyClass directly
    MyClass myClassInstance = (MyClass) clazzConstructor.newInstance(); // MyClass Object Created!
    System.out.println(myClassInstance); // MyClass Object
  }
}

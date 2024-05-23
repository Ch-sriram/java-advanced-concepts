package reflection.ReflectionDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class MyClass {
  public MyClass() {
    System.out.println("MyClass Object Created!");
  }

  public String toString() {
    return "MyClass Object";
  }
}

public class ReflectionDemo {
  public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
      InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    // MyClass myClass = new MyClass(); // error: MyClass() has private access in MyClass

    /**
     * 1. We can make use of `Class.forName` to create an object of the class as follows:
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

    /**
     * 2. All class objects created from the same class will get the same object
     */
    Class<?> clazz1 = Class.forName("reflection.ReflectionDemo.MyClass");
    Class<?> clazz2 = Class.forName("reflection.ReflectionDemo.MyClass");
    System.out.println(clazz1 == clazz2); // true

    Class<?> clazz3 = Class.forName("java.lang.String");
    Class<?> clazz4 = Class.forName("java.lang.String");
    System.out.println(clazz3 == clazz4); // true

    /**
     * 3. Using [ClassName].class to get the class object.
     *    - We can use this for primitives as well, which will return the corresponding wrapper class.s
     */

    Class<?> clazz5 = int.class; // This will return the class object for intSSS
    Class<?> clazz6 = String.class; // This will return the class object for String

    /**
     * 4. <instance>.getClass()
     * 
     * // myClassInstance.getClass(); // This will return the class object for MyClass
     */
    MyClass m = new MyClass();
    Class<? extends MyClass> clazz7 = m.getClass(); // This will return the class object for MyClass
    System.out.println(clazz7);

    // To get superclasses
    clazz7 = (Class<? extends MyClass>) clazz7.getSuperclass();

    // To get the interfaces of the class
    Class<?>[] interfaces = clazz7.getInterfaces();
    System.out.println(interfaces);

    // To get the name of the class
    String className = clazz7.getName();
    System.out.println(className); // reflection.ReflectionDemo.MyClass
  }
}

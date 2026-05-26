package oop.Overloading;

/**
 * Overloading is a concept where we can define methods with the same name which should definitely differ in their method 
 * signatures. A method signature is the number of arguments and type of arguments that are sent into the method.
 * 
 * Example: "void m1();" and "void m1(int x);" are overloaded methods because they've different method signatures with one 
 * taking in no parameters and the other taking in an integer.
 * 
 * Now, Overloading is also sometimes known as Static Polymorphism or Early Binding or Compile Time Polymorphism because
 * the resolution of the which methods to be executed which are overloaded is done at compile time by the javac.
 */

public class OverloadingExample {
    public void m1() {
        System.out.println("m1() with no-args!");
    }
    
    public void m1(int x) {
        System.out.println("m1() with int-arg: " + x);
    }
    
    public void m1(float x) {
        System.out.println("m1() with float-arg: " + x);
    }

    public void add(int x, int y) {
        System.out.println(x + y);
    }

    public void add(int x, int y, int z) {
        System.out.println(x + y + z);
    }
    
    public static void main(String[] args) {
        OverloadingExample over = new OverloadingExample();
        over.m1(); // m1() with no-args!
        over.m1(10); // m1() with int-arg: 10
        over.m1(5.54f); // m1() with float-arg: 5.54

        // Major benefit of overloading is that we can use the method same name to give extra functionality to the method
        over.add(10, 20); // 30
        over.add(10, 20, 30); // 60


        // There's a concept of automatic promotion when we overload something. So, if we do the following:
        over.m1('a'); // m1() with int-arg: 97

        // Here, in line 44, when 'a' is sent to the m1() method, the JVM first tries to match it with a method which might
        // be of the signature "void m1(char x)", and when that's not available, then it goes to check if the next type's
        // signature is available which is "void m1(short x)", and when even that is not available, it goes to look for 
        // the method with the signature "void m1(int x)" and it will automatically promote character 'a' to an integer 
        // type. And so, we get the output as the unicode/ascii value of 'a' which is 97.
    }
}
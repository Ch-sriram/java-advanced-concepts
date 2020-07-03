package oop.MethodHiding;

/**
 * In Method Hiding, we override static method of Parent class inside the Child class. The final method bound to the object depends on the reference type 
 * used, whether it is the Parent class' reference or the Child class' reference.
 */

class Parent {
    int i = 888;
    public static void add(int x, int y) {
        System.out.println(x + y);
    }
}

class Child extends Parent {
    int i = 999;
    public static void add(int x, int y) {
        System.out.println(x + y + 100);
    }
}

public class MethodHidingExample {
    public static void main(String[] args) {
        Parent p1 = new Parent();
        p1.add(100, 100); // 200

        Child c = new Child();
        c.add(100, 100); // 300

        Parent p2 = new Child();
        p2.add(100, 100); // 200 => here, we can see that since we use the Parent class' reference, add() of Parent class is called.

        System.out.println(p1.i); // 888
        System.out.println(c.i); // 999
        System.out.println(p2.i); // 888 => here also, we can see that 'i' is an attribute of Parent class since we used Parent class' reference for Child class' object
    }
}